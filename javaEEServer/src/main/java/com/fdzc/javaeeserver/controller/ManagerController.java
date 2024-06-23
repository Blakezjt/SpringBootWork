package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.ManagerServiceImpl;
import com.fdzc.javaeeserver.validate.Manager.ManagerCreateValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerLoginValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerSearchValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Manager.ManagerDetailVo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerServiceImpl managerServiceImpl;

    @PostMapping("/login")
    public R login(@Validated  ManagerLoginValidate managerLoginValidate){
        return managerServiceImpl.login(managerLoginValidate);
    }

    @GetMapping("/list")
    public R managerList(@Validated PageValidate pageValidate,
                         @Validated ManagerSearchValidate searchValidate){

        return R.success(managerServiceImpl.managerList(pageValidate,searchValidate));
    }

    @GetMapping("/detail")
    public R managerDetail(@Validated @RequestParam("id") String id){
        ManagerDetailVo detailVo = managerServiceImpl.managerDetail(id);
        return R.success(detailVo);
    }
    @PostMapping("/edit")
    public R managerEdit(@Validated @RequestBody ManagerUpdateValidate updateValidate){
        managerServiceImpl.managerEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R managerAdd(@Validated @RequestBody ManagerCreateValidate createValidate){
        managerServiceImpl.managerAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R managerDelete(@Validated @RequestParam("id") String id){
        managerServiceImpl.managerDelete(id);
        return R.success();
    }
}
