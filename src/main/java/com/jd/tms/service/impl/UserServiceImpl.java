package com.jd.tms.service.impl;

import com.jd.tms.dto.UserDto;
import com.jd.tms.manager.UserManager;
import com.jd.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:34
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    /**
     * 保存用户信息
     * @param userDto
     */
    @Override
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto, "参数为空");
        Date now = new Date();
        userDto.setUserCode(UUID.fromString(userDto.getUserName()).toString().replaceAll("-", "").substring(0, 8));
        userDto.setCreateTime(now);
        userDto.setUpdateTime(now);
        return userManager.save(userDto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    @Override
    public List<UserDto> findUsers() {
        return userManager.findUsers();
    }

    @Override
    public List<UserDto> findUserByCondition(UserDto dto) {
        Assert.notNull(dto, "参数为空");
        return userManager.findUserByCondition(dto);
    }
    /**
     * 更新对象
     */
    @Override
    public void updateUser(UserDto userDto) {
        Assert.notNull(userDto, "参数为空");
        userManager.updateUser(userDto);
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        Assert.notNull(id, "参数为空");
        userManager.deleteUserById(id);
    }
}
