package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<TeacherEntity, Integer> {
    TeacherEntity getTeacherEntityByUsernameAndPass(String username, String pass);
}
