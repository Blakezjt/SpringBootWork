package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Emergencycontact;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
public interface EmergencycontactService extends IService<Emergencycontact> {

    boolean add(Emergencycontact emergencycontact);

    IPage<Emergencycontact> studentlist(Integer id, Page<Emergencycontact> emergencycontactPage);

    IPage<Emergencycontact> teacherlist(Page<Emergencycontact> emergencycontactPage);

    boolean deletebyId(Integer id);
}
