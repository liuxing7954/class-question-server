package com.fullcalendar.demo;

import com.fullcalendar.demo.entity.*;
import com.fullcalendar.demo.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StudentService studentService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ClassService classService;

    @Test
    public void student() {
        StudentEntity studentEntity = studentService.login("jixiaoyi", "123456");
        Assert.assertNotNull("无此用户",studentEntity);
        List<TeacherEntity> teacherEntities = teacherService.list();
        Assert.assertNotEquals("没有老师列表",0,teacherEntities.size());
        List<QuestionEntity> questionEntities = questionService.list(teacherEntities.get(0).getId());
        Assert.assertNotEquals("相关老师没有问题列表",0,questionEntities.size());
        AnswerEntity answerEntity = answerService.answerOrUpdate(questionEntities.get(0).getId(), studentEntity.getId(), "一个很正式的回答");
        Assert.assertNotNull("回答问题失败",answerEntity);
    }

    @Test
    public void teacher() {
        TeacherEntity teacherEntity = teacherService.login("admin", "bd**123");
        Assert.assertNotNull("无此用户",teacherEntity);
        List<ClassEntity> classEntities = classService.getAllClasses();
        Assert.assertNotEquals("没有查询出班级列表",0,classEntities.size());
        List<SubjectEntity> subjectEntities = subjectService.getAllSubject(teacherEntity.getId());
        Assert.assertNotEquals("没有查询出科目列表",0,subjectEntities.size());
        QuestionEntity questionEntity = questionService.add(teacherEntity.getId(), "测试题目1", "很长很长很长很长很长很长很长很长很长很长的内容", subjectEntities.get(0).getId(), classEntities.get(0).getId());
        Assert.assertNotNull("提问失败",questionEntity);
        List<QuestionEntity> questionEntities = questionService.listBySubjectId(subjectEntities.get(0).getId());
        Assert.assertNotEquals("没有查询出题目列表",0,questionEntities.size());
        questionEntity = questionService.closeOrOpenQuestion(questionEntity.getId());
        Assert.assertNotNull("关闭问题失败",questionEntity);
        List<AnswerEntity> answerEntities = answerService.list(questionEntities.get(0).getId());
        Assert.assertNotEquals("没有回答列表",0,answerEntities.size());
    }

}
