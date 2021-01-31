package com.jd.tms.manager;

import com.jd.tms.dao.ProfessorDao;
import com.jd.tms.dao.ResearchTopicDao;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.ResearchTopicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:02
 */
@Component
public class ResearchTopicManager {

    @Autowired
    private ResearchTopicDao researchTopicDao;

    /**
     * 保存用户信息
     * @param dto
     */
    public ResearchTopicDto save(ResearchTopicDto dto) {
        Assert.notNull(dto, "参数为空");
        return researchTopicDao.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ResearchTopicDto> findAll() {
        return researchTopicDao.findAll();
    }

    public List<ResearchTopicDto> findAllByCondition(ResearchTopicDto dto) {
        Assert.notNull(dto, "参数为空");
        return researchTopicDao.findAllByCondition(dto);
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
