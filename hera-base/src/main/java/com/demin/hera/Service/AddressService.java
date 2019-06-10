package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.AddressDao;
import com.demin.hera.Pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import springfox.documentation.annotations.Cacheable;
import org.springframework.cache.annotation.Cacheable;      //使用上面的无效
/**
 * 对Address的增删改查
 * 并对数据进行缓存
 * Created by  Domain
 * on 2019/6/4 16:24;
 */

public interface AddressService extends BaseService<Address> {

}
