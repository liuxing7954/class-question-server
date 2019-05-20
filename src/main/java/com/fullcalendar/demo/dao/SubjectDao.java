package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectDao extends JpaRepository<SubjectEntity,Integer> {
    public List<SubjectEntity> getSubjectEntitiesByTeacherId(int teacherId);
}
