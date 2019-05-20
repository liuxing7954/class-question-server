package com.fullcalendar.demo.controller;

import com.fullcalendar.demo.VO.ResultVO;
import com.fullcalendar.demo.entity.AnswerEntity;
import com.fullcalendar.demo.entity.QuestionEntity;
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
@RequestMapping("/api/question")
@Api(
        tags = "问题模块"
)
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @ApiOperation(
            value = "学生回答",
            httpMethod = "POST"
    )
    @RequestMapping("/answer")
    public ResultVO answer(int questionId, int studentId, String content) {
        if (questionService.query(questionId) == null) {
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        }
        if (studentService.query(studentId) == null) {
            return ResultVOUtil.error(ResultEnum.STUDENT_NOT_EXIST);
        }
        AnswerEntity entity = answerService.answerOrUpdate
                (questionId, studentId, content);
        if (entity == null) {
            return ResultVOUtil.error(ResultEnum.ANSWER_ERROR);
        }
        return ResultVOUtil.success(entity);
    }

    @ApiOperation(
            value = "老师提问",
            httpMethod = "POST"
    )
    @RequestMapping("/question")
    public ResultVO question(int teacherId, String title, String content, int subjectId, int classId) {
        if (teacherService.query(teacherId) == null) {
            return ResultVOUtil.error(ResultEnum.TEACHER_NOT_EXIST);
        }
        QuestionEntity entity = questionService.add(teacherId, title, content, subjectId, classId);
        if (entity == null) {
            return ResultVOUtil.error(ResultEnum.QUESTION_ERROR);
        }
        return ResultVOUtil.success(entity);
    }


    @ApiOperation(
            value = "获取问题列表",
            httpMethod = "POST"
    )
    @RequestMapping("/listQuestion")
    public ResultVO listQuestion(int subjectId) {
        return ResultVOUtil.success(questionService.listBySubjectId(subjectId));
    }

    @ApiOperation(
            value = "获取答案列表",
            httpMethod = "POST"
    )
    @RequestMapping("/listAnswer")
    public ResultVO listAnswer(int questionId) {
        return ResultVOUtil.success(answerService.list(questionId));
    }


    @ApiOperation(
            value = "删除问题",
            httpMethod = "POST"
    )
    @RequestMapping("/delQuestion")
    public ResultVO delQuestion(int questionId) {
        try {
            questionService.delQuestion(questionId);
            return ResultVOUtil.success(null);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.DEL_QUESTION_ERROR);
        }
    }

    @ApiOperation(
            value = "问题详情",
            httpMethod = "POST"
    )
    @RequestMapping("/detail")
    public ResultVO detail(int questionId) {
        return ResultVOUtil.success(questionService.query(questionId));
    }


    @ApiOperation(
            value = "关闭问题",
            httpMethod = "POST"
    )
    @RequestMapping("/close")
    public ResultVO close(int questionId) {
        return ResultVOUtil.success(questionService.closeOrOpenQuestion(questionId));
    }


}
