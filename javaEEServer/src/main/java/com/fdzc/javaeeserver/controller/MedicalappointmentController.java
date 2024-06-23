package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.entity.Medicalappointment;
import com.fdzc.javaeeserver.service.MedicalappointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@RestController
@RequestMapping("/medicalappointment")
public class MedicalappointmentController {

    @Autowired
    private MedicalappointmentService medicalappointmentService;

    @PostMapping("/add")
    public R add(@RequestBody Medicalappointment medicalappointment){
        boolean save=medicalappointmentService.add(medicalappointment);
        if (!save){
            return R.error();
        } else {
            return R.success(medicalappointment);
        }
    }

    //老师查看多个学生请假状态（分页）
    @GetMapping("/teacherlist")
    public R teacherlist(@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Medicalappointment> medicalappointmentPage = new Page<>(page, size);
        return R.success(medicalappointmentService.teacherlist(medicalappointmentPage));
    }

    //学生查看自己的请假信息
    @GetMapping("/studentlist")
    public R studentlist(@PathParam("studentId") Integer studentId,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Medicalappointment> medicalappointmentPage = new Page<>(page, size);
        return R.success(medicalappointmentService.studentlist(studentId,medicalappointmentPage));
    }

    //老师根据学生id来修改审核状态
    @PutMapping("/update")
    public R update(@RequestBody Medicalappointment medicalappointment){
        boolean update=medicalappointmentService.updateById(medicalappointment);
        if (!update){
            return R.error();
        } else {
            return R.success(medicalappointment);
        }
    }

    //删除请假申请记录
    @DeleteMapping("/deletebyId")
    public R deletebyId(@PathParam("id") Integer id) {
        boolean delete=medicalappointmentService.deletebyId(id);
        if (!delete){
            return R.error();
        } else {
            return R.success("applicationId为"+id+"被成功删除");
        }
    }

}
