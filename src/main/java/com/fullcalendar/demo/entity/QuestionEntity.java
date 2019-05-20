package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class QuestionEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    private SubjectEntity subject;
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private ClassEntity clazz;
    private int teacherId;
    private String title;
    private String content;
    private boolean isClose;
}
