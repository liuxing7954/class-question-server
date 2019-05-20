package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
public class AnswerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int questionId;
    private String content;
//    private int studentId;
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private StudentEntity student;
}
