package com.demin.hera.Service;

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
@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;


    //@Cacheable(value = "addressCache")
    public Address saveAddress(Address address){
        return addressDao.save(address);
    }
    /**
     * 对每次查询进行缓存，每次的记录key为：类名_findById_id
     * 目前只对查询做缓存，添加删除更新不做缓存
     * @param id
     * @return
     */
    @Cacheable(value = "addressCache")
    public Address findById(Integer id){
        return addressDao.findById(id).get();
    }

    public void deleteById(Integer id){
        addressDao.deleteById(id);
    }


    public Address updateAddress(Address address){
        return addressDao.save(address);
    }
}
