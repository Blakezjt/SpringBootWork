package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Manager;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.mapper.ManagerMapper;
import com.fdzc.javaeeserver.service.ManagerService;
import com.fdzc.javaeeserver.utils.Md5Utils;
import com.fdzc.javaeeserver.validate.Manager.ManagerCreateValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerSearchValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Manager.ManagerDetailVo;
import com.fdzc.javaeeserver.vo.Manager.ManagerListVo;
import com.fdzc.javaeeserver.vo.student.StudentDetailVo;
import com.fdzc.javaeeserver.vo.student.StudentListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;


    @Override
    public T managerList(PageValidate pageValidate, ManagerSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("admin_id");


        Page<Manager> page = managerMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
        List<ManagerListVo> list = new LinkedList<>();
        for (Manager manager: page.getRecords()) {
            ManagerListVo vo = new ManagerListVo();
            BeanUtils.copyProperties(manager,vo);
            list.add(vo);
        }

        return T.success(list, (int) page.getTotal());
    }

    @Override
    public ManagerDetailVo managerDetail(String id) {
        Manager manager = managerMapper.selectOne(new QueryWrapper<Manager>()
                .eq("admin_id", id)
                .last("limit 1"));
        ManagerDetailVo detailVo = new ManagerDetailVo();
        BeanUtils.copyProperties(manager,detailVo);
        return detailVo;
    }

    @Override
    public void managerEdit(ManagerUpdateValidate updateValidate) {
        Manager manager = managerMapper.selectOne(new QueryWrapper<Manager>()
                .eq("admin_id", updateValidate.getAdminId())
                .last("limit 1"));
        manager.setUpdateTime(LocalDateTime.now());
        manager.setRole(updateValidate.getRole());
        manager.setPassword(updateValidate.getPassword());

    }

    @Override
    public void managerAdd(ManagerCreateValidate createValidate) {
        Manager manager = new Manager();
        manager.setAdminId(UUID.randomUUID().toString());
        manager.setUserName(createValidate.getUserName());
        manager.setPassword(Md5Utils.encode(createValidate.getPassword()));
        manager.setPhone(createValidate.getPhone());
        manager.setRole(createValidate.getRole());
        manager.setName(createValidate.getName());
        manager.setCreateTime(LocalDateTime.now());
        manager.setUpdateTime(LocalDateTime.now());
        managerMapper.insert(manager);
    }

    @Override
    public void managerDelete(String id) {
        Manager manager = managerMapper.selectOne(new QueryWrapper<Manager>()
                .eq("student_id", id));
        manager.setIsDelete(1);
        manager.setDeleteTime(LocalDateTime.now());
        managerMapper.updateById(manager);
    }
}
