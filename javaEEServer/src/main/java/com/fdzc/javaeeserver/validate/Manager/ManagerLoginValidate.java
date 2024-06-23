package com.fdzc.javaeeserver.validate.Manager;

import lombok.Data;

@Data
public class ManagerLoginValidate {
    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;
}
