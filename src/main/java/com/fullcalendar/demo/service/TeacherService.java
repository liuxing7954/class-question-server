package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.TeacherDao;
import com.fullcalendar.demo.entity.TeacherEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService {
    @Autowired
    TeacherDao dao;
    public TeacherEntity login(String username,String pass){
        TeacherEntity entity = dao.getTeacherEntityByUsernameAndPass(username, pass);
        return entity;
    }

    public TeacherEntity query(int id){
        Optional<TeacherEntity> optional = dao.findById(id);
        return optional.orElse(null);
    }

    public List<TeacherEntity> list(){
        List<TeacherEntity> all = dao.findAll();
        return all;
    }




}
