package com.demin.hera.Dao;




import com.demin.hera.Entity.EsItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by  Domain
 * on 2019/6/9 15:38;
 */
public interface ItemEsDao extends ElasticsearchRepository<EsItem,String> {
}
