package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDao extends JpaRepository<ClassEntity,Integer> {
}
