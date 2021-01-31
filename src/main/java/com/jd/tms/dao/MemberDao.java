package com.jd.tms.dao;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProfessorDto;
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
public class MemberDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户信息
     * @param dto
     */
    public MemberDto save(MemberDto dto) {
        return mongoTemplate.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<MemberDto> findAll() {
        return mongoTemplate.findAll(MemberDto.class);
    }

    public List<MemberDto> findAllByCondition(MemberDto dto) {
        Query query=new Query();
        boolean queryFlag = false;
        if (StringUtil.isNotBlank(dto.getProfessorCode())) {
            queryFlag = true;
            query.addCriteria(Criteria.where("professorCode").is(dto.getProfessorCode()));
        }

        return mongoTemplate.find(query , MemberDto.class);
    }


}
