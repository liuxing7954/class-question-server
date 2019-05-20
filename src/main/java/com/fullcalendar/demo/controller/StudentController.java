package com.fullcalendar.demo.controller;

import com.fullcalendar.demo.VO.ResultVO;
import com.fullcalendar.demo.entity.AnswerEntity;
import com.fullcalendar.demo.entity.QuestionEntity;
import com.fullcalendar.demo.entity.StudentEntity;
import com.fullcalendar.demo.entity.TeacherEntity;
import com.fullcalendar.demo.enums.ResultEnum;
import com.fullcalendar.demo.service.AnswerService;
import com.fullcalendar.demo.service.QuestionService;
import com.fullcalendar.demo.service.StudentService;
import com.fullcalendar.demo.service.TeacherService;
import com.fullcalendar.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@Api(
        tags = "学生模块"
)
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;

    @ApiOperation(
            value = "学生登录",
            httpMethod = "POST"
    )
    @RequestMapping("/login")
    public ResultVO register(String username, String password) {
        StudentEntity entity = studentService.login(username, password);
        if (entity == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
        return ResultVOUtil.success(entity);
    }


}
