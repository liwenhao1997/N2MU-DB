package com.jd.tms.manager;

import com.jd.tms.dao.UserDao;
import com.jd.tms.dto.UserDto;
import com.jd.tms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:02
 */
@Component
public class UserManager {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户信息
     * @param userDto
     */
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto, "参数为空");
        return userDao.save(userDto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<UserDto> findUsers() {
        return userDao.findUsers();
    }

    public List<UserDto> findUserByCondition(UserDto dto) {
        Assert.notNull(dto, "参数为空");
        return userDao.findUserByCondition(dto);
    }
    /**
     * 更新对象
     */
    public void updateUser(UserDto userDto) {
        Assert.notNull(userDto, "参数为空");
        userDao.updateUser(userDto);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Integer id) {
        Assert.notNull(id, "参数为空");
        userDao.deleteUserById(id);
    }

}
