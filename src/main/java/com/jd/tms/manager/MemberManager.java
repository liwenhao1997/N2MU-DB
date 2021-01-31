package com.jd.tms.manager;

import com.jd.tms.dao.MemberDao;
import com.jd.tms.dao.ProfessorDao;
import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:02
 */
@Component
public class MemberManager {

    @Autowired
    private MemberDao memberDao;

    /**
     * 保存用户信息
     * @param dto
     */
    public MemberDto save(MemberDto dto) {
        Assert.notNull(dto, "参数为空");
        return memberDao.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<MemberDto> findAll() {
        return memberDao.findAll();
    }

    public List<MemberDto> findAllByCondition(MemberDto dto) {
        Assert.notNull(dto, "参数为空");
        return memberDao.findAllByCondition(dto);
    }

}
