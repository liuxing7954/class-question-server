package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.QuestionEntity;
import com.fullcalendar.demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAllByTeacherId(int teacherId);
    List<QuestionEntity> findAllByTeacherIdAndSubjectId(int teacherId,int subjectId);
    List<QuestionEntity> findAllBySubjectId(int subjectId);
}
