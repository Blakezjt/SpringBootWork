package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Healthreport;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.mapper.HealthreportMapper;
import com.fdzc.javaeeserver.service.HealthreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fdzc.javaeeserver.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@Service
public class HealthreportServiceImpl extends ServiceImpl<HealthreportMapper, Healthreport> implements HealthreportService {

    @Autowired
    HealthreportMapper healthreportMapper;

    @Override
    public boolean add(Healthreport healthreport) {
        healthreport.setDate(LocalDate.parse(DateUtil.createDate()));
        int add = healthreportMapper.insert(healthreport);
        if (add != 1) {
            return false;
        }
        return true;
    }



    @Override
    public IPage<Healthreport> teacherlist(Page<Healthreport> page) {
        LambdaQueryWrapper<Healthreport> queryWrapper = new LambdaQueryWrapper<>();
        return healthreportMapper.selectPage(page,queryWrapper);
    }

    @Override
    public IPage<Healthreport> studentlist(Integer id,Page<Healthreport> page) {
        LambdaQueryWrapper<Healthreport> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Healthreport::getStudentId,id);
        return healthreportMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean deletebyId(Integer id) {
        int isdelete = healthreportMapper.deleteById(id);
        if (isdelete>0){
            return true;
        } else {
            return false;
        }
    }
}
