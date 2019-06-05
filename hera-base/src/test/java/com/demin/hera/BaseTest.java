package com.demin.hera;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by  Domain
 * on 2019/6/4 12:40;
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HeraBaseApplication.class)
@WebAppConfiguration
public class BaseTest {
    @Before
    public void before(){
        System.err.println("============= Base Test Start===============");
    }

    @After
    public void after(){
        System.err.println("==============Base Test End=================");
    }
}
