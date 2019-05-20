package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.AnswerDao;
import com.fullcalendar.demo.dao.ClassDao;
import com.fullcalendar.demo.dao.QuestionDao;
import com.fullcalendar.demo.dao.SubjectDao;
import com.fullcalendar.demo.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    @Autowired
    AnswerDao answerDao;
    @Autowired
    SubjectDao subjectDao;
    @Autowired
    ClassDao classDao;

    public QuestionEntity add(int teacherId, String title, String content,int subjectId,int classId) {
        QuestionEntity entity = new QuestionEntity();
        entity.setTeacherId(teacherId);
        entity.setTitle(title);
        entity.setContent(content);
        try {
            entity.setSubject(subjectDao.findById(subjectId).get());
            entity.setClazz(classDao.findById(classId).get());
        } catch (Exception e) {
            return null;
        }
        return questionDao.save(entity);
    }

    public QuestionEntity query(int id) {
        Optional<QuestionEntity> optional = questionDao.findById(id);
        return optional.orElse(null);
    }

    public List<QuestionEntity> list(int teacherId) {
        List<QuestionEntity> all = questionDao.findAllByTeacherId(teacherId);
        return all;
    }
    public List<QuestionEntity> listBySubjectId(int subjectId) {
        List<QuestionEntity> all = questionDao.findAllBySubjectId(subjectId);
        return all;
    }

    public QuestionEntity closeOrOpenQuestion(int questionId){
        QuestionEntity one = questionDao.findById(questionId).orElse(null);
        if(one == null)
            return null;
        one.setClose(!one.isClose());
        return questionDao.save(one);
    }

    @Transactional
    public void delQuestion(int questionId) {
        try {
            answerDao.deleteAllByQuestionId(questionId);
            questionDao.deleteById(questionId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
