package com.css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/2/20 20:43
 */

//测试类类名必须包含Test
public class MvnTest {

    @Test
    //方法名必须由小写test开头，加其它字符，否则使用命令进行测试时会识别不了
    public void testAssert() {
        int a = 10;
        int b= 20;
        Assertions.assertEquals(a+b,30);
    }
}
