package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Idcard;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
public interface IdcardService extends IService<Idcard> {

    public boolean addcard(Idcard idcard);

    IPage<Idcard> teacherlist(Page<Idcard> idcardPage);

    IPage<Idcard> studentlist(Integer studentId, Page<Idcard> idcardPage);

    boolean deletebyId(String id);
}
