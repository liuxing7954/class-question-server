package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.StudentDao;
import com.fullcalendar.demo.dao.TeacherDao;
import com.fullcalendar.demo.entity.QuestionEntity;
import com.fullcalendar.demo.entity.StudentEntity;
import com.fullcalendar.demo.entity.TeacherEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public StudentEntity login(String username,String pass){
        StudentEntity entity = studentDao.getStudentEntityByUsernameAndPass(username, pass);
        return entity;
    }

    public StudentEntity query(int id){
        Optional<StudentEntity> optional = studentDao.findById(id);
        return optional.orElse(null);
    }

}
