package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.ClassDao;
import com.fullcalendar.demo.entity.ClassEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClassService {

    @Autowired
    ClassDao classDao;

    public List<ClassEntity> getAllClasses(){
        return classDao.findAll();
    }
}
