package com.jd.tms.dao;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProdiumDto;
import com.jd.tms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
@Repository
public class ProdiumDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     * @param dto
     */
    public ProdiumDto save(ProdiumDto dto) {
        return mongoTemplate.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ProdiumDto> findAll() {
        return mongoTemplate.findAll(ProdiumDto.class);
    }

    public List<ProdiumDto> findAllByCondition(ProdiumDto dto) {
        Query query=new Query();
        if (StringUtil.isNotBlank(dto.getProfessorCode())) {
            query.addCriteria(Criteria.where("professorCode").is(dto.getProfessorCode()));
        }

        return mongoTemplate.find(query , ProdiumDto.class);
    }


}
