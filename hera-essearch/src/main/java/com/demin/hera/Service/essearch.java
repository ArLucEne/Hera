package com.demin.hera.Service;


import com.demin.hera.Dao.ItemEsDao;


import com.demin.hera.Entity.EsItem;
import com.demin.hera.Feign.ItemFeign;
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

import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/9 15:36;
 */
@Service
public class essearch {
    private static final Logger LOGGER = LoggerFactory.getLogger(essearch.class);

    @Autowired
    ItemFeign itemFeign;

    @Autowired
    ItemEsDao esDao;        //elasticsearch索引持久对象

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;        //es检索操作template

    /**
     * 从商品名称和卖点以及描述对key作模糊查询，分页返回
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<EsItem> queryByKey(String key, int pageNum, int pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("name", key))
                .should(QueryBuilders.matchQuery("point", key))
                .should(QueryBuilders.matchQuery("desc", key));    //对key，name,desc三个字段查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(queryBuilder).withPageable(pageable)
                .withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC));    //按照sale降序返回
        NativeSearchQuery query = nativeSearchQueryBuilder.build();     //开始查询
        LOGGER.info("DSL:{}", query.getQuery().toString());
        return elasticsearchTemplate.queryForPage(query,EsItem.class);
    }

    public List<EsItem> getAll(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        return elasticsearchTemplate.queryForList(searchQuery,EsItem.class);
    }

    /**
     * 当商品有更新时同步数据索引
     * @return
     */
    public List<EsItem> syncData(){
        List<EsItem> items = itemFeign.fetchItem();
        System.out.println("feign to fetch");
        esDao.saveAll(items);
        return getAll();
    }
}
