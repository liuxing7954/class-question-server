package com.fullcalendar.demo.VO;

import lombok.Data;

@Data
public class ResultVO {
    private int error_code;
    private String msg;
    private Object data;
}
