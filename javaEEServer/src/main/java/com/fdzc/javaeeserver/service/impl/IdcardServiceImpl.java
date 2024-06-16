package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Idcard;
import com.fdzc.javaeeserver.mapper.IdcardMapper;
import com.fdzc.javaeeserver.service.IdcardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fdzc.javaeeserver.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@Service
public class IdcardServiceImpl extends ServiceImpl<IdcardMapper, Idcard> implements IdcardService {
    @Autowired
    IdcardMapper idcardMapper;

    @Override
    public boolean addcard(Idcard idcard) {
        idcard.setIdCardId(UUID.randomUUID().toString());

        //设置当前日期为创建日期
        LocalDate localDate = LocalDate.parse(DateUtil.createDate());
        idcard.setIssueDate(LocalDate.parse(DateUtil.createDate()));

        //设置有效期为创建日期加上4年
        LocalDate expirationDate = localDate.plusYears(4);
        idcard.setExpirationDate(expirationDate);

        int add = idcardMapper.insert(idcard);
        if (add!=1){
            return false;
        }
        return true;
    }

    @Override
    public IPage<Idcard> teacherlist(Page<Idcard> idcardPage) {
        LambdaQueryWrapper<Idcard> queryWrapper =new LambdaQueryWrapper<>();
        return idcardMapper.selectPage(idcardPage,queryWrapper);
    }

    @Override
    public IPage<Idcard> studentlist(Integer studentId, Page<Idcard> idcardPage) {
        LambdaQueryWrapper<Idcard> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Idcard::getStudentId,studentId);
        return idcardMapper.selectPage(idcardPage,queryWrapper);
    }

    @Override
    public boolean deletebyId(String id) {
        int delete = idcardMapper.deleteById(id);
        if (delete>0){
            return true;
        } else {
            return false;
        }
    }
}
