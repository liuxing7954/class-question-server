package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@Data
public class ClassEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
}
