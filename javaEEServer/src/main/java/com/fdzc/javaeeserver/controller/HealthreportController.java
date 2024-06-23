package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Healthreport;
import com.fdzc.javaeeserver.service.HealthreportService;
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
@RequestMapping("/healthreport")
public class HealthreportController {
    @Autowired
    HealthreportService healthreportService;

    //学生每日添加健康打卡
    @PostMapping("/add")
    public R add(@RequestBody Healthreport healthreport){
        boolean save=healthreportService.add(healthreport);
        if (!save){
            return R.error();
        } else {
            return R.success(healthreport);
        }
    }

    //老师查看多个学生健康打卡状态（分页）
    @GetMapping("/teacherlist")
    public R teacherlist(@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Healthreport> healthreportPage = new Page<>(page, size);
        return R.success(healthreportService.teacherlist(healthreportPage));
    }

    //学生查看自己的健康打卡状态记录（分页）
    @GetMapping("/studentlist")
    public R studentlist(@PathParam("studentId") Integer studentId,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Healthreport> healthreportPage = new Page<>(page, size);
        return R.success(healthreportService.studentlist(studentId,healthreportPage));
    }

    @GetMapping("/studentlist2")
    public R studentlist2(@PathParam("healthStatus") String healthStatus,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Healthreport> healthreportPage = new Page<>(page, size);
        return R.success(healthreportService.studentlist2(healthStatus,healthreportPage));
    }


    //老师根据学生id来修改审核状态
    @PostMapping("/update")
    public R update(@RequestBody Healthreport healthreport){
        boolean update=healthreportService.updateById(healthreport);
        if (!update){
            return R.error();
        } else {
            return R.success(healthreport);
        }
    }

    //删除学生健康打卡记录
    @DeleteMapping("/deletebyId")
    public R deletebyId(@PathParam("reportId") Integer reportId) {
        boolean delete=healthreportService.deletebyId(reportId);
        if (!delete){
            return R.error();
        } else {
            return R.success("reportId为"+reportId+"被成功删除");
        }
    }
}
