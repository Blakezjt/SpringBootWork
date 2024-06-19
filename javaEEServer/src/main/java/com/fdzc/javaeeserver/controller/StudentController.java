package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.service.impl.StudentServiceImpl;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.student.StudentCreateValidate;
import com.fdzc.javaeeserver.validate.student.StudentLoginValidate;
import com.fdzc.javaeeserver.validate.student.StudentSearchValidate;
import com.fdzc.javaeeserver.validate.student.StudentUpdateValidate;
import com.fdzc.javaeeserver.vo.student.StudentDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentServiceImpl studentServiceImpl;

//    @GetMapping("/login")
//    public R login( StudentLoginValidate studentLoginValidate){//将@RequestBody加在RuleForm ruleForm前面时可以再postman中运行
//        R resultV0 = studentServiceImpl.login(studentLoginValidate);
//        return resultV0;
//    }

    @GetMapping("/list")
    public R studentList(@Validated PageValidate pageValidate,
                         @Validated StudentSearchValidate studentSearchValidate){

        return R.success(studentServiceImpl.studentList(pageValidate,studentSearchValidate));
    }

    @GetMapping("/detail")
    public R studentDetail(@Validated @RequestParam("id") Integer studentId){
        StudentDetailVo studentDetailVo = studentServiceImpl.studentDetail(studentId);
        return R.success(studentDetailVo);
    }
    @PostMapping("/edit")
    public R studentEdit(@Validated @RequestBody StudentUpdateValidate updateValidate){
        studentServiceImpl.studentEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R studentAdd(@Validated @RequestBody StudentCreateValidate createValidate){
        studentServiceImpl.studentAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R studentDelete(@Validated @RequestParam("id") Integer studentId){
        studentServiceImpl.studentDelete(studentId);
        return R.success();
    }
}
