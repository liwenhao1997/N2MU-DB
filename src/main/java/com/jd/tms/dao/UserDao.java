package com.jd.tms.dao;

import com.jd.tms.dto.UserDto;
import com.jd.tms.exception.CommonException;
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
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     * @param userDto
     */
    public UserDto save(UserDto userDto) {
        return mongoTemplate.save(userDto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<UserDto> findUsers() {
//        Query query=new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.findAll(UserDto.class);
    }

    public List<UserDto> findUserByCondition(UserDto userDto) {
        Query query=new Query();
        boolean queryFlag = false;
        if (StringUtil.isNotBlank(userDto.getUserName())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("userName").is(userDto.getUserName()));
        }
        if (StringUtil.isNotBlank(userDto.getUserPhone())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("userPhone").is(userDto.getUserPhone()));
        }
        if (StringUtil.isNotBlank(userDto.getEmail())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("email").is(userDto.getEmail()));
        }
//        if (!queryFlag) {
//            throw new CommonException("查询参数为空");
//        }
        return mongoTemplate.find(query , UserDto.class);
    }
    /**
     * 更新对象
     */
    public void updateUser(UserDto userDto) {
        Query query=new Query(Criteria.where("id").is(userDto.getId()));
        Update update= new Update();
        if (StringUtil.isNotBlank(userDto.getUserName())) {
            update.set("userName", userDto.getUserName());
        }
        if (StringUtil.isNotBlank(userDto.getUserPhone())) {
            update.set("userPhone", userDto.getUserPhone());
        }
        if (StringUtil.isNotBlank(userDto.getEmail())) {
            update.set("email", userDto.getEmail());
        }
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, UserDto.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserDto.class);
    }


}
