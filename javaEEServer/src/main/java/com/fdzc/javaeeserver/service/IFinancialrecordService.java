package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Financialrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fdzc.javaeeserver.entity.Payment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
public interface IFinancialrecordService extends IService<Financialrecord> {
    //分页查询
    IPage<Financialrecord> list(Page<Financialrecord> page);

    IPage<Financialrecord> getFinancialByStudentId(Page<Financialrecord> page, Integer studentId);

    IPage<Financialrecord> getFinancialByType(Page<Financialrecord> page, String transactionType);
}
