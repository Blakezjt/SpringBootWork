package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Emergencycontact;
import com.fdzc.javaeeserver.entity.Healthreport;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.service.EmergencycontactService;
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
@RequestMapping("/emergencycontact")
public class EmergencycontactController {
    @Autowired
    EmergencycontactService emergencycontactService;

    //学生添加紧急联系人
    @PostMapping("/add")
    public R add(@RequestBody Emergencycontact emergencycontact){
        boolean save=emergencycontactService.add(emergencycontact);
        if (!save){
            return R.error();
        } else {
            return R.success(emergencycontact);
        }
    }

    //学生查看自己的紧急联系人列表（分页）
    @GetMapping("/studentlist")
    public IPage<Emergencycontact> studentlist(@PathParam("id") Integer id,@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Emergencycontact> emergencycontactPage = new Page<>(page, size);
        return emergencycontactService.studentlist(id,emergencycontactPage);
    }

    //老师查看学生的紧急联系人列表（分页）
    @GetMapping("/teacherlist")
    public IPage<Emergencycontact> teacherlist(@PathParam("page") Integer page, @PathParam("size") Integer size){
        Page<Emergencycontact> emergencycontactPage = new Page<>(page, size);
        return emergencycontactService.teacherlist(emergencycontactPage);
    }

    //根据学生id来修改学生紧急联系人
    @PutMapping("/update")
    public R update(@RequestBody Emergencycontact emergencycontact){
        boolean update=emergencycontactService.updateById(emergencycontact);
        if (!update){
            return R.error();
        } else {
            return R.success(emergencycontact);
        }
    }

    //学生删除紧急联系人
    @DeleteMapping("/deletebyId")
    public R deletebyId(@RequestParam Integer id) {
        boolean delete=emergencycontactService.deletebyId(id);
        if (!delete){
            return R.error();
        } else {
            return R.success("emergencycontactId为"+id+"被成功删除");
        }
    }

}
