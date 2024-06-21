package com.fdzc.javaeeserver.vo.Manager;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerDetailVo {

    private static final long serialVersionUID = 1L;

    private String adminId;

    private String name;

    private String userName;

    private String password;

    private String role;

    private String phone;
}
