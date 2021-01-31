package com.jd.tms.service.impl;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.manager.MemberManager;
import com.jd.tms.manager.ProfessorManager;
import com.jd.tms.service.MemberService;
import com.jd.tms.service.ProfessorService;
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
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberManager memberManager;

    /**
     * 保存用户信息
     * @param dto
     */
    @Override
    public MemberDto save(MemberDto dto) {
        Assert.notNull(dto, "参数为空");
        Assert.hasText(dto.getName(), "用户名为空，不保存信息");
        Date now = new Date();
        if (dto.getId() == null) {
            dto.setCreateTime(now);
        }
        dto.setUpdateTime(now);
        dto.setYn(1);
        return memberManager.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    @Override
    public List<MemberDto> findAll() {
        return memberManager.findAll();
    }

    @Override
    public List<MemberDto> findAllByCondition(MemberDto dto) {
        Assert.notNull(dto, "参数为空");
        return memberManager.findAllByCondition(dto);
    }
}
