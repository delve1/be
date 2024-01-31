package com.example.projectbe.service;

import com.example.projectbe.dto.UserDto;

import ch.qos.logback.core.model.Model;

public interface UserService {
    public void addUser(UserDto dto);

    public void getInfo(Model model);
    
    public void updateUser(UserDto dto);
    
    public void updatePassword(UserDto dto);
}