package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 14:26 2020-01-20
 * @version: V1.0
 * @review:
 */
@SpringBootApplication(scanBasePackages = {"com.cas"})
public class ApplicationTest {

    public static void main(String[] args) {
        try{
            SpringApplication.run(ApplicationTest.class, args);
            System.out.println("测试环境启动成功！！！！");
        } catch (Exception e) {
            System.out.println("测试环境启动失败！！！！");
        }
    }
}
