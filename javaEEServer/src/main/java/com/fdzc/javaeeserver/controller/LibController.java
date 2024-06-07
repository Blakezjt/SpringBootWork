package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Lib;
import com.fdzc.javaeeserver.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getAllList")
public class LibController {

    @Autowired
    private LibService libService;

    public T getAllList(){
    List<Lib> rows = libService.getAllList();
    Integer a = libService.getAllList().size();
    return T.success(rows,"查询成功",a);
    }

}
