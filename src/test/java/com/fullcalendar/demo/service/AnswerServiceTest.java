package com.fullcalendar.demo.service;

import com.alibaba.fastjson.JSON;
import com.fullcalendar.demo.entity.AnswerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceTest {

    @Autowired
    AnswerService service;

    @Test
    public void list() {
        List<AnswerEntity> list = service.list(1);
        System.out.println(JSON.toJSONString(list));
    }
}