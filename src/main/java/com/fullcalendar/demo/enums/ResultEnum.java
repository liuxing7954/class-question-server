package com.fullcalendar.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    LOGIN_ERROR(-100,"登录错误"),
    TEACHER_NOT_EXIST(-201,"老师不存在"),
    QUESTION_NOT_EXIST(-202,"问题不存在"),
    STUDENT_NOT_EXIST(-203,"学生不存在"),
    QUESTION_ERROR(-301,"提问失败"),
    ANSWER_ERROR(-302,"回答失败"),
    DEL_QUESTION_ERROR(-401,"删除问题失败"),
    ;
    private int code;
    private String msg;

}
