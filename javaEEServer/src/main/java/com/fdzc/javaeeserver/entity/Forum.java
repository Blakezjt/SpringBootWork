package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId
    private Integer postId;
    private Integer studentId;
    private String topic;
    private LocalDateTime postDate;
}
