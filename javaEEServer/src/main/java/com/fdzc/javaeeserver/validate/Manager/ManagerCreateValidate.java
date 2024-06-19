package com.fdzc.javaeeserver.validate.Manager;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerCreateValidate {

    private static final long serialVersionUID = 1L;

    private String adminId;

    private String name;

    private String userName;

    private String password;

    private String role;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
