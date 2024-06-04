package com.thesis.chat_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private short age;

    private short gender;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
