package com.demin.hera.Service;





import com.demin.hera.Dao.ItemEsDao;
import com.demin.hera.Entity.EsItem;
import com.demin.hera.Feign.ItemFeign;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/9 15:36;
 */
@Service
public class Essearch {
    private static final Logger LOGGER = LoggerFactory.getLogger(Essearch.class);

    @Autowired
    ItemFeign itemFeign;

    @Autowired
    ItemEsDao esDao;        //elasticsearch索引持久对象

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;        //es检索操作template

    /**
     * 从商品名称和卖点以及描述对key作模糊查询，分页返回
     * @param key
     * @return
     */
    public List<EsItem> queryByKey(String key){

        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("name", key))
                .should(QueryBuilders.matchQuery("sellPoint", key))
                .should(QueryBuilders.matchQuery("description", key));    //对key，name,desc三个字段查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(queryBuilder)
               .withSort(SortBuilders.scoreSort().order(SortOrder.DESC));    //按照sale降序返回
        NativeSearchQuery query = nativeSearchQueryBuilder.build();     //开始查询
        LOGGER.info("DSL:{}", query.getQuery().toString());
        return elasticsearchTemplate.queryForList(query,EsItem.class);
    }

    public List<EsItem> getAll(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        return elasticsearchTemplate.queryForList(searchQuery,EsItem.class);
    }



    public List<EsItem> recommend(List<String> itemIds) {
        List<String> categoryNameList = new LinkedList<String>();
        if (itemIds.size() != 0) {
            List<EsItem> esItems = new LinkedList<>();

            for(String itemId:itemIds){
                EsItem item = itemFeign.findById(itemId);
                esItems.add(item);
                categoryNameList.add(item.getItemCatName());
            }
        }
        String[] itemCatNames = new String[categoryNameList.size()];
        String[] temp = categoryNameList.toArray(itemCatNames);
        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = QueryBuilders
                .moreLikeThisQuery(new String[] { "itemCatName" }, temp,null)
                .minTermFreq(1);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(moreLikeThisQueryBuilder)

                .withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        return elasticsearchTemplate.queryForList(query, EsItem.class);
    }

    /**
     * 当商品有更新时同步数据索引
     * @return
     */
    public List<EsItem> syncData(){
        LOGGER.info("Use feign to fetch all items");
        List<EsItem> items = itemFeign.fetchItem();
        esDao.deleteAll();
        esDao.saveAll(items);
        LOGGER.info("SYNC DATA");
        return getAll();
    }
}
