package com.fdzc.javaeeserver.controller.Exams;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.GradesServiceImpl;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.grades.GradesCreateValidate;
import com.fdzc.javaeeserver.validate.grades.GradesSearchValidate;
import com.fdzc.javaeeserver.validate.grades.GradesUpdateValidate;
import com.fdzc.javaeeserver.vo.Grades.GradesDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("grades")
public class GradesController {

    @Resource
    private GradesServiceImpl gradesServiceImpl;
    @GetMapping("/list")
    public R gradesList(@Validated PageValidate pageValidate,
                       @Validated GradesSearchValidate searchValidate){

        return R.success(gradesServiceImpl.gradesList(pageValidate,searchValidate));
    }

    @GetMapping("/{id}")
    public R gradesDetail(@Validated @PathVariable String id){
        GradesDetailVo DetailVo = gradesServiceImpl.gradesDetail(id);
        return R.success(DetailVo);
    }
    @PostMapping("/edit")
    public R gradesEdit(@Validated @RequestBody GradesUpdateValidate updateValidate){
        gradesServiceImpl.gradesEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R gradesAdd(@Validated @RequestBody GradesCreateValidate createValidate){
        gradesServiceImpl.gradesAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R gradesDelete(@Validated @RequestParam("id") String id){
        gradesServiceImpl.gradesDelete(id);
        return R.success();
    }
}
