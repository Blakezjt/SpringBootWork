package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.Manager.ManagerCreateValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerSearchValidate;
import com.fdzc.javaeeserver.validate.Manager.ManagerUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Manager.ManagerDetailVo;

public interface ManagerService {

    T managerList(PageValidate pageValidate, ManagerSearchValidate searchValidate);

    ManagerDetailVo managerDetail(String id);

    void managerEdit(ManagerUpdateValidate updateValidate);

    void managerAdd(ManagerCreateValidate createValidate);

    void managerDelete(String id);
}
