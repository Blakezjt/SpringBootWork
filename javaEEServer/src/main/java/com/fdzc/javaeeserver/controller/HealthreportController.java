package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Healthreport;
import com.fdzc.javaeeserver.service.HealthreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/teacherlist/{page}/{size}")
    public IPage<Healthreport> teacherlist(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<Healthreport> healthreportPage = new Page<>(page, size);
        return healthreportService.teacherlist(healthreportPage);
    }

    //学生查看自己的健康打卡状态记录（分页）
    @GetMapping("/studentlist/{id}/{page}/{size}")
    public IPage<Healthreport> studentlist(@PathVariable("id") Integer id,@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<Healthreport> healthreportPage = new Page<>(page, size);
        return healthreportService.studentlist(id,healthreportPage);
    }

    //删除学生健康打卡记录
    @DeleteMapping("/deletebyId/{id}")
    public R deletebyId(@PathVariable Integer id) {
        boolean delete=healthreportService.deletebyId(id);
        if (!delete){
            return R.error();
        } else {
            return R.success("reportId为"+id+"被成功删除");
        }
    }
}
