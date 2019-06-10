package com.demin.hera.ServiceImpl;

import com.demin.hera.Dao.ShippingDao;
import com.demin.hera.Pojo.Shipping;
import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Service.ShippingService;
import org.springframework.stereotype.Service;

/**
 * Created by  Domain
 * on 2019/6/10 20:31;
 */
@Service
public class ShippingServiceImpl extends BaseServiceImpl<Shipping, ShippingDao> implements ShippingService {
}
