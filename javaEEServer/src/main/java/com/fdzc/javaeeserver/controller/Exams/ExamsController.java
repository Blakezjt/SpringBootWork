package com.fdzc.javaeeserver.controller.Exams;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.ExamsServiceImpl;
import com.fdzc.javaeeserver.validate.Exams.ExamsCreateValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsSearchValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Exams.ExamsDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("exam")
public class ExamsController {

    @Resource
    private ExamsServiceImpl examsServiceImpl;

    @GetMapping("/list")
    public R examsList(@Validated PageValidate pageValidate,
                         @Validated ExamsSearchValidate examsSearchValidate){

        return R.success(examsServiceImpl.examsList(pageValidate,examsSearchValidate));
    }

    @GetMapping("/detail")
    public R examsDetail(@Validated @RequestParam("id") Integer id){
        ExamsDetailVo examsDetailVo = examsServiceImpl.examsDetail(id);
        return R.success(examsDetailVo);
    }
    @PostMapping("/edit")
    public R examsEdit(@Validated @RequestBody ExamsUpdateValidate updateValidate){
        examsServiceImpl.examsEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R examsAdd(@Validated @RequestBody ExamsCreateValidate createValidate){
        examsServiceImpl.examsAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R examsDelete(@Validated @RequestParam("id") Integer id){
        examsServiceImpl.examsDelete(id);
        return R.success();
    }
}
