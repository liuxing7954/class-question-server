package com.fullcalendar.demo.controller;

import com.fullcalendar.demo.VO.ResultVO;
import com.fullcalendar.demo.entity.QuestionEntity;
import com.fullcalendar.demo.entity.TeacherEntity;
import com.fullcalendar.demo.enums.ResultEnum;
import com.fullcalendar.demo.service.ClassService;
import com.fullcalendar.demo.service.QuestionService;
import com.fullcalendar.demo.service.SubjectService;
import com.fullcalendar.demo.service.TeacherService;
import com.fullcalendar.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
@Api(
        tags = "老师模块"
)
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    QuestionService questionService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ClassService classService;

    @ApiOperation(
            value = "老师登录",
            httpMethod = "POST"
    )
    @RequestMapping("/login")
    public ResultVO register(String username, String password) {
        TeacherEntity teacherEntity = teacherService.login(username, password);
        if (teacherEntity == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
        return ResultVOUtil.success(teacherEntity);
    }

    @ApiOperation(
            value = "获取老师列表",
            httpMethod = "POST"
    )
    @RequestMapping("/list")
    public ResultVO list() {
        return ResultVOUtil.success(teacherService.list());
    }


    @ApiOperation(
            value = "获取老师所属科目列表",
            httpMethod = "POST"
    )
    @RequestMapping("/listSubject")
    public ResultVO listSubject(int teacherId) {
        return ResultVOUtil.success(subjectService.getAllSubject(teacherId));
    }

    @ApiOperation(
            value = "获取班级列表",
            httpMethod = "POST"
    )
    @RequestMapping("/listClass")
    public ResultVO listClass() {
        return ResultVOUtil.success(classService.getAllClasses());
    }


}
