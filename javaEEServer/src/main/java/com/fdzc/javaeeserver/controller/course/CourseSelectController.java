package com.fdzc.javaeeserver.controller.course;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.CourseSelectionServiceImpl;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseSelectDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("courseSelect")
public class CourseSelectController {

    @Resource
    private CourseSelectionServiceImpl selectionServiceImpl;


    @GetMapping("/list")
    public R courseSelectList(@Validated PageValidate pageValidate,
                         @Validated CourseSelectSearchValidate searchValidate){

        return R.success(selectionServiceImpl.courseSelectionList(pageValidate,searchValidate));
    }

    @GetMapping("/detail")
    public R courseSelectDetail(@Validated @RequestParam("id") Integer id){
        CourseSelectDetailVo DetailVo = selectionServiceImpl.courseSelectionDetail(id);
        return R.success(DetailVo);
    }

    @PostMapping("/edit")
    public R courseSelectEdit(@Validated @RequestBody CourseSelectUpdateValidate updateValidate){
        selectionServiceImpl.courseSelectionEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R courseSelectAdd(@Validated @RequestBody CourseSelectCreateValidate createValidate){
        selectionServiceImpl.courseSelectionAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R courseSelectDelete(@Validated @RequestParam("id") Integer id){
        selectionServiceImpl.courseSelectionDelete(id);
        return R.success();
    }
}
