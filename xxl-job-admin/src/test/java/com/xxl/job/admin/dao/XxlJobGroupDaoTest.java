package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XxlJobGroupDaoTest {

    @Resource
    private XxlJobGroupDao xxlJobGroupDao;

    @Test
    public void test() {
        List<XxlJobGroup> list = xxlJobGroupDao.findAll();
        System.out.println(list);

        List<XxlJobGroup> list2 = xxlJobGroupDao.findByAddressType(0);
        System.out.println(list2);

        XxlJobGroup group = new XxlJobGroup();
        group.setAppname("setAppName");
        group.setTitle("setTitle");
        group.setAddressType(0);
        group.setAddressList("setAddressList");

        int ret = xxlJobGroupDao.save(group);
        System.out.println(ret);

        XxlJobGroup group2 = xxlJobGroupDao.load(group.getId());
        group2.setAppname("setAppName2");
        group2.setTitle("setTitle2");
        group2.setAddressType(2);
        group2.setAddressList("setAddressList2");

        int ret2 = xxlJobGroupDao.update(group2);
        System.out.println(ret2);
        
        int ret3 = xxlJobGroupDao.remove(group.getId());
        System.out.println(ret3);
    }

}
