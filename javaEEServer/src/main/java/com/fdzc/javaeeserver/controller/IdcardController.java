package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Idcard;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.service.IdcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@RestController
@RequestMapping("/idcard")
public class IdcardController {
    @Autowired
    IdcardService idcardService;

    @PostMapping("/add")
    public R add(@RequestBody Idcard idcard){
        boolean save=idcardService.addcard(idcard);
        if (!save){
            return R.error();
        } else {
            return R.success(idcard);
        }
    }



}
