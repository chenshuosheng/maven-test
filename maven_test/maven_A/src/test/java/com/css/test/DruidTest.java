package com.css.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/2/21 21:49
 */
public class DruidTest {

    @Test
    public void testDruid(){
        System.out.println(DruidDataSource.DEFAULT_MAX_ACTIVE_SIZE);
    }
}
