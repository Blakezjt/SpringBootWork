package com.fdzc.javaeeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Forum {
    private Integer postId;
    private Integer studentId;
    private String topic;
    private LocalDateTime postDate;
}
