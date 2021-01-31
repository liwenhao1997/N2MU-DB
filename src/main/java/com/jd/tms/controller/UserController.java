package com.jd.tms.controller;

import com.jd.tms.dto.CommonDto;
import com.jd.tms.dto.UserDto;
import com.jd.tms.service.UserService;
import com.jd.tms.util.JacksonUtil;
import com.jd.tms.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户信息
     * @param userDto
     */
    @PostMapping
    public CommonDto<UserDto> save(@RequestBody UserDto userDto) {
        if (userDto == null) {
            return CommonDto.constructWithWarnMessage("保存信息为空");
        }
        if (StringUtil.isBlank(userDto.getUserName())) {
            return CommonDto.constructWithWarnMessage("用户名为空");
        }
        try {
            UserDto save = userService.save(userDto);
            return CommonDto.constructWithNormalMessage("创建成功", save);
        } catch (Exception e) {
            return CommonDto.constructWithExpMessage("创建失败");
        }
    }

    /**
     * 根据用户名查询对象
     * @return
     */
//    @GetMapping()
//    public List<UserDto> findUsers() {
//        return userService.findUsers();
//    }

    @GetMapping
    public List<UserDto> findUserByCondition(UserDto dto) {
        log.info(JacksonUtil.toJson(dto));
        return userService.findUserByCondition(dto);
    }
    /**
     * 更新对象
     */
    public void updateUser(UserDto userDto) {
        userService.updateUser(userDto);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Integer id) {
        userService.deleteUserById(id);
    }
}
