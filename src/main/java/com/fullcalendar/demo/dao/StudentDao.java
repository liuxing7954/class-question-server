package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.StudentEntity;
import com.fullcalendar.demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity, Integer> {
    StudentEntity getStudentEntityByUsernameAndPass(String username, String pass);
}
