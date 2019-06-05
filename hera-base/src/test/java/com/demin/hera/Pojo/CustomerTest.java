package com.demin.hera.Pojo;

import com.demin.hera.BaseTest;
import com.demin.hera.Dao.*;
import org.junit.Test;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by  Domain
 * on 2019/6/4 12:40;
 */
public class CustomerTest extends BaseTest {
    @Autowired
    AddressDao addressDao;
    @Autowired
    AdminDao adminDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ItemCategoryDao categoryDao;
    @Autowired
    ItemCartDao cartDao;
    @Autowired
    ItemOrderDao itemOrderDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ShippingDao shippingDao;
    @Test
    public void baseTest(){
        Address address = Address.getTestEntity();
        addressDao.save(address);
        Optional<Address> add = addressDao.findById(1);
        if(add.isPresent())
            System.out.println(add.get().toString());
        address.setCity("qingdao");
        addressDao.save(address);

        System.out.println(addressDao.findById(1).toString());

        Admin admin = Admin.getTestEntity();
        adminDao.save(admin);

        Customer customer = Customer.getTestEntity();
        customerDao.save(customer);

        Item item = Item.getTestEntity();
        itemDao.save(item);

        ItemCategory category = ItemCategory.getTestEntity();
        categoryDao.save(category);

        ItemCart cart = ItemCart.getTestEntity();
        cartDao.save(cart);

        ItemOrder itemOrder = ItemOrder.getTestEntity();
        itemOrderDao.save(itemOrder);

        Order order = Order.getTestEntity();
        orderDao.save(order);

        Shipping shipping = Shipping.getTestEntity();
        shippingDao.save(shipping);

    }
}