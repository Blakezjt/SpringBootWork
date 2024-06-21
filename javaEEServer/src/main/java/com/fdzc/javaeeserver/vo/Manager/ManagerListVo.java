package com.fdzc.javaeeserver.vo.Manager;

import lombok.Data;

@Data
public class ManagerListVo {

    private static final long serialVersionUID = 1L;

    private String adminId;

    private String name;

    private String userName;

    private String password;

    private String role;

    private String phone;
}
