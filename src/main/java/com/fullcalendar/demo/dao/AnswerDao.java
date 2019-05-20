package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.AnswerEntity;
import com.fullcalendar.demo.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao extends JpaRepository<AnswerEntity, Integer> {
    List<AnswerEntity> findAllByQuestionId(int teacherId);
    AnswerEntity getAnswerEntityByQuestionIdAndStudentId(int questionId,int studentId);
    void deleteAllByQuestionId(int questionId);
}
