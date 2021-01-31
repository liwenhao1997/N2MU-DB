package com.jd.tms.dao;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 17:24
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessorDaoTest {

    @Autowired
    private ProfessorDao professorDao;
    @Test
    public void test01() {
//        System.out.println(JacksonUtil.toJson(professorDao.findAllByCondition(new ProfessorDto())));
    }
}
