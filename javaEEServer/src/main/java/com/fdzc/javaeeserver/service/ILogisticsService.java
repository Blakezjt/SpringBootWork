package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Logistics;
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
public interface ILogisticsService extends IService<Logistics> {
    //分页查询
    IPage<Logistics> list(Page<Logistics> page);
    //状态查询记录分页
    IPage<Logistics> getLogisticsByStatus(Page<Logistics> page, String status);
}
