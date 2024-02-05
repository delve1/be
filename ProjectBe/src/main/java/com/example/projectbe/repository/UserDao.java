package com.example.projectbe.repository;

import com.example.projectbe.dto.UserDto;

public interface UserDao {
    public void insert(UserDto dto);

    public UserDto getData(String userName);

    public void update(UserDto dto);
    
    public void updatePwd(UserDto dto);
}