package com.fdzc.javaeeserver.service;

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
}
