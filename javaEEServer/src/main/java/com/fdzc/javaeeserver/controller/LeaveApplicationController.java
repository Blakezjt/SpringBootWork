package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/leaveapplication")
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    //学生新增请假业务
    @PostMapping("/add")
    public R add(@RequestBody LeaveApplication leaveApplication){
        boolean save=leaveApplicationService.add(leaveApplication);
        if (!save){
            return R.error();
        } else {
            return R.success(leaveApplication);
        }
    }

    //老师查看多个学生请假状态（分页）
    @GetMapping("/teacherlist")
    public IPage<LeaveApplication> teacherlist(@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<LeaveApplication> leaveApplicationPagepage = new Page<>(page, size);
        return leaveApplicationService.teacherlist(leaveApplicationPagepage);
    }

    //学生查看自己的请假信息
    @GetMapping("/studentlist")
    public IPage<LeaveApplication> studentlist(@PathParam("studentId") Integer studentId,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<LeaveApplication> leaveApplicationPagepage = new Page<>(page, size);
        return leaveApplicationService.studentlist(studentId,leaveApplicationPagepage);
    }

    //根据请假状态查询
    @GetMapping("/studentlist2")
    public IPage<LeaveApplication> studentlist2(@PathParam("approvalStatus") String approvalStatus,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<LeaveApplication> leaveApplicationPagepage = new Page<>(page, size);
        return leaveApplicationService.studentlist2(approvalStatus,leaveApplicationPagepage);
    }
    //老师根据学生id来修改审核状态
    @PostMapping("/update")
    public R update(@RequestBody LeaveApplication leaveApplication){
        boolean updateleaveapplication=leaveApplicationService.updateById(leaveApplication);
        if (!updateleaveapplication){
            return R.error();
        } else {
            return R.success(leaveApplication);
        }
    }

    //删除请假申请记录
    @DeleteMapping("/deletebyId")
    public R deletebyId(@PathParam("applicationId") Integer applicationId) {
        boolean delete=leaveApplicationService.deletebyId(applicationId);
        if (!delete){
            return R.error();
        } else {
            return R.success("applicationId为"+applicationId+"被成功删除");
        }
    }

}
