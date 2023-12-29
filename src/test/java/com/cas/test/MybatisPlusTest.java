package com.cas.test;

import com.cas.ApplicationTest;
import com.cas.mapper.CasRuleActCompositeMapper;
import com.cas.pojo.CasRuleActComposite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 【单表操作】
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisPlusTest {

    @Resource
    private CasRuleActCompositeMapper casRuleInfoMapper;


    /**
     * mybatis-plus查询操作【单表】
     */
    @Test
    public void testSelect2() {
        System.out.println(("----- selectAll method test ------"));
        List<CasRuleActComposite> list = casRuleInfoMapper.selectList(null);
        System.out.println("a");
    }

}
