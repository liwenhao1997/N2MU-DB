package com.jd.tms.dao;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.UserDto;
import com.jd.tms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
@Repository
public class ProfessorDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     * @param dto
     */
    public ProfessorDto save(ProfessorDto dto) {
        return mongoTemplate.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ProfessorDto> findAll() {
        return mongoTemplate.findAll(ProfessorDto.class);
    }

    public List<ProfessorDto> findAllByCondition(ProfessorDto dto) {
        Query query=new Query();
        boolean queryFlag = false;
        if (StringUtil.isNotBlank(dto.getCode())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("code").is(dto.getCode()));
        }
        if (StringUtil.isNotBlank(dto.getName())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("name").is(dto.getName()));
        }
        if (dto.getContactInfo() != null && StringUtil.isNotBlank(dto.getContactInfo().getPhone())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("contactInfo.phone").is(dto.getContactInfo().getPhone()));
        }
//        if (!queryFlag) {
//            throw new CommonException("查询参数为空");
//        }
        return mongoTemplate.find(query , ProfessorDto.class);
    }
    /**
     * 更新对象
     */
//    public void updateProfessor(ProfessorDto dto) {
//        Query query=new Query(Criteria.where("id").is(dto.getId()));
//        Update update= new Update();
//        if (StringUtil.isNotBlank(dto.getUserName())) {
//            update.set("userName", dto.getUserName());
//        }
//        if (StringUtil.isNotBlank(dto.getUserPhone())) {
//            update.set("userPhone", dto.getUserPhone());
//        }
//        if (StringUtil.isNotBlank(dto.getEmail())) {
//            update.set("email", dto.getEmail());
//        }
//        //更新查询返回结果集的第一条
//        mongoTemplate.updateFirst(query, update, UserDto.class);
//        //更新查询返回结果集的所有
//        // mongoTemplate.updateMulti(query,update,TestEntity.class);
//    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteProcessorById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,ProfessorDto.class);
    }


}
