package com.jd.tms.manager;

import com.jd.tms.dao.ProfessorDao;
import com.jd.tms.dao.UserDao;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:02
 */
@Component
public class ProfessorManager {

    @Autowired
    private ProfessorDao professorDao;

    /**
     * 保存用户信息
     * @param dto
     */
    public ProfessorDto save(ProfessorDto dto) {
        Assert.notNull(dto, "参数为空");
        return professorDao.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ProfessorDto> findAll() {
        return professorDao.findAll();
    }

    public List<ProfessorDto> findAllByCondition(ProfessorDto dto) {
        Assert.notNull(dto, "参数为空");
        return professorDao.findAllByCondition(dto);
    }
    /**
     * 更新对象
     */
//    public void updateUser(ProfessorDto dto) {
//        Assert.notNull(dto, "参数为空");
//        professorDao.u(dto);
//    }

    /**
     * 删除对象
     * @param id
     */
//    public void deleteUserById(Integer id) {
//        Assert.notNull(id, "参数为空");
//        userDao.deleteUserById(id);
//    }

}
