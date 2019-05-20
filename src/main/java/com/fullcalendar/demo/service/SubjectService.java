package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.SubjectDao;
import com.fullcalendar.demo.entity.SubjectEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;


    public List<SubjectEntity> getAllSubject(int teacherId){
        return subjectDao.getSubjectEntitiesByTeacherId(teacherId);
    }
}
