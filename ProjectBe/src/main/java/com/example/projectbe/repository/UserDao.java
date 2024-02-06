package com.example.projectbe.repository;

import com.example.projectbe.dto.Provider;
import com.example.projectbe.dto.UserDto;

public interface UserDao {
    public void insert(UserDto dto);
    
    public void update(UserDto dto);
    
    public void updateRefreshToken(String refreshToken);
    
    public UserDto findByUserId(Long userId);

    public UserDto findByEmail(String email);

    public UserDto findByUsername(String username);
    
    public UserDto findByProviderAndSocialId(Provider provider, String socialId);

    
}