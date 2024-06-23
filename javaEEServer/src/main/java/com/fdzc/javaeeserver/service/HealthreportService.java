package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Healthreport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
public interface HealthreportService extends IService<Healthreport> {

    boolean add(Healthreport healthreport);

    IPage<Healthreport> teacherlist(Page<Healthreport> healthreportPage);

    boolean deletebyId(Integer id);

    IPage<Healthreport> studentlist(Integer id,Page<Healthreport> healthreportPage);

    IPage<Healthreport> studentlist2(String healthStatus, Page<Healthreport> healthreportPage);
}
