package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaveapplication")
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    //新增
    @PostMapping("/add")
    public R add(@RequestBody LeaveApplication leaveApplication){
        boolean save=leaveApplicationService.add(leaveApplication);
        if (!save){
            return R.error();
        } else {
            return R.success();
        }

    }
}
