package com.jd.tms.service;

import com.jd.tms.dto.UserDto;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
public interface UserService {
    UserDto save(UserDto userDto);

    List<UserDto> findUsers();

    List<UserDto> findUserByCondition(UserDto dto);

    void updateUser(UserDto userDto);

    void deleteUserById(Integer id);
}
