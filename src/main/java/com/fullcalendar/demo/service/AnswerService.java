package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.AnswerDao;
import com.fullcalendar.demo.dao.StudentDao;
import com.fullcalendar.demo.entity.AnswerEntity;
import com.fullcalendar.demo.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AnswerService {
    @Autowired
    AnswerDao dao;
    @Autowired
    StudentDao studentDao;
    public AnswerEntity answerOrUpdate(int questionId, int studentId, String content){
        AnswerEntity entity = dao.getAnswerEntityByQuestionIdAndStudentId(questionId, studentId);
        if(entity == null){
            entity = new AnswerEntity();
        }
        entity.setQuestionId(questionId);
        entity.setStudent(studentDao.getOne(studentId));
        entity.setContent(content);
        return dao.save(entity);
    }


    public List<AnswerEntity> list(int questionId){
        List<AnswerEntity> all = dao.findAllByQuestionId(questionId);
        return all;
    }

}
