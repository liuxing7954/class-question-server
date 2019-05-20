package com.fullcalendar.demo.service;

import com.fullcalendar.demo.VO.ResultVO;
import com.fullcalendar.demo.controller.QuestionController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    QuestionController controller;
    @Test
    public void delQuestion() {
        ResultVO resultVO = controller.delQuestion(1);
        Assert.assertEquals("删除失败",0,resultVO.getError_code());
    }
}