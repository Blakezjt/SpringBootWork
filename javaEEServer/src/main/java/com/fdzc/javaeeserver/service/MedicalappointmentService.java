package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Medicalappointment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
public interface MedicalappointmentService extends IService<Medicalappointment> {

    boolean add(Medicalappointment medicalappointment);

    IPage<Medicalappointment> teacherlist(Page<Medicalappointment> medicalappointmentPage);

    IPage<Medicalappointment> studentlist(Integer studentId, Page<Medicalappointment> medicalappointmentPage);

    boolean deletebyId(Integer id);
}
