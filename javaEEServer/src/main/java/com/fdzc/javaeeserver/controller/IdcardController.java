package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Idcard;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.service.IdcardService;
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
@RequestMapping("/idcard")
public class IdcardController {
    @Autowired
    IdcardService idcardService;

    //添加证件
    @PostMapping("/add")
    public R add(@RequestBody Idcard idcard){
        boolean save=idcardService.addcard(idcard);
        if (!save){
            return R.error();
        } else {
            return R.success(idcard);
        }
    }

    //老师查看多个学生证件状态（分页）
    @GetMapping("/teacherlist")
    public IPage<Idcard> teacherlist(@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Idcard> idcardPage = new Page<>(page, size);
        return idcardService.teacherlist(idcardPage);
    }

    //学生查看自己的证件信息
    @GetMapping("/studentlist")
    public IPage<Idcard> studentlist(@PathParam("studentId") Integer studentId,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Idcard> idcardPage = new Page<>(page, size);
        return idcardService.studentlist(studentId,idcardPage);
    }

    //老师根据学生id来修改审核状态
    @PutMapping("/update")
    public R update(@RequestBody Idcard idcard){
        boolean update=idcardService.updateById(idcard);
        if (!update){
            return R.error();
        } else {
            return R.success(idcard);
        }
    }

    //删除请假申请记录
    @DeleteMapping("/deletebyId")
    public R deletebyId(@PathParam("id") String id) {
        boolean delete=idcardService.deletebyId(id);
        if (!delete){
            return R.error();
        } else {
            return R.success("证件号为"+id+"被成功删除");
        }
    }

}
