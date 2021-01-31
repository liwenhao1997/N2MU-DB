package com.jd.tms.service.impl;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.manager.ProfessorManager;
import com.jd.tms.service.ProfessorService;
import com.jd.tms.util.StringUtil;
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
@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorManager professorManager;

    /**
     * 保存用户信息
     * @param dto
     */
    @Override
    public ProfessorDto save(ProfessorDto dto) {
        Assert.notNull(dto, "参数为空");
        Assert.hasText(dto.getName(), "用户名为空，不保存信息");
        Date now = new Date();
        dto.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
        if (dto.getId() == null) {
            dto.setCreateTime(now);
        }
        dto.setUpdateTime(now);
        dto.setYn(1);
        return professorManager.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    @Override
    public List<ProfessorDto> findAll() {
        return professorManager.findAll();
    }

    @Override
    public List<ProfessorDto> findAllByCondition(ProfessorDto dto) {
        Assert.notNull(dto, "参数为空");
        return professorManager.findAllByCondition(dto);
    }
    /**
     * 更新对象
     */
//    @Override
//    public void updateUser(UserDto userDto) {
//        Assert.notNull(userDto, "参数为空");
//        userManager.updateUser(userDto);
//    }

    /**
     * 删除对象
     * @param id
     */
//    @Override
//    public void deleteUserById(Integer id) {
//        Assert.notNull(id, "参数为空");
//        userManager.deleteUserById(id);
//    }
}
