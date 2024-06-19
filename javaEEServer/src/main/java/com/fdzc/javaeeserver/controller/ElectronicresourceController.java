package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Electronicresource;

import com.fdzc.javaeeserver.service.IElectronicresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/c")
public class ElectronicresourceController {

    @Autowired
    private IElectronicresourceService iElectronicresourceService;

    @GetMapping()
    public R query(){
        return R.success(iElectronicresourceService.list());
    }
    @GetMapping("/selectById")
    public R query1(Integer resourceId){
        return R.success(iElectronicresourceService.getById(resourceId));
    }
    @DeleteMapping("/deleteById")
    public R delete(Integer resourceId){
        return R.success(iElectronicresourceService.removeById(resourceId),"删除成功");
    }
    @PutMapping("/add")
    public R add(Electronicresource electronicresource){
        return R.success(iElectronicresourceService.save(electronicresource),"添加成功");
    }

}
