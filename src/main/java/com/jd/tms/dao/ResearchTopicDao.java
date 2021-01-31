package com.jd.tms.dao;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.ResearchTopicDto;
import com.jd.tms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
@Repository
public class ResearchTopicDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     * @param dto
     */
    public ResearchTopicDto save(ResearchTopicDto dto) {
        return mongoTemplate.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ResearchTopicDto> findAll() {
        return mongoTemplate.findAll(ResearchTopicDto.class);
    }

    public List<ResearchTopicDto> findAllByCondition(ResearchTopicDto dto) {
        Query query=new Query();
        if (StringUtil.isNotBlank(dto.getProfessorCode())) {
            query.addCriteria(Criteria.where("professorCode").is(dto.getProfessorCode()));
        }
        return mongoTemplate.find(query , ResearchTopicDto.class);
    }

//    public ResearchTopicDto findById()
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
//     */
//    public void deleteProcessorById(Integer id) {
//        Query query=new Query(Criteria.where("id").is(id));
//        mongoTemplate.remove(query,ProfessorDto.class);
//    }


}
