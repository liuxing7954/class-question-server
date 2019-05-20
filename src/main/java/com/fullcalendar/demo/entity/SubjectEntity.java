package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Data
public class SubjectEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private int teacherId;
    private String name;
}
