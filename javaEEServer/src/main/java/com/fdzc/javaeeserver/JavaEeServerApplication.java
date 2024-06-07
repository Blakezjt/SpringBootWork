package com.fdzc.javaeeserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fdzc.javaeeserver.mapper")
public class JavaEeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaEeServerApplication.class, args);
    }

}
