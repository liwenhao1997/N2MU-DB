package com.jd.tms.service.impl;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProdiumDto;
import com.jd.tms.manager.MemberManager;
import com.jd.tms.manager.ProdiumManager;
import com.jd.tms.service.MemberService;
import com.jd.tms.service.ProdiumService;
import com.jd.tms.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:34
 */
@Service("prodiumService")
public class ProdiumServiceImpl implements ProdiumService {

    @Autowired
    private ProdiumManager prodiumManager;

    /**
     * 保存用户信息
     * @param dto
     */
    @Override
    public ProdiumDto save(ProdiumDto dto) {
        Assert.notNull(dto, "参数为空");
        Date now = new Date();
        if (dto.getId() == null) {
            dto.setCreateTime(now);
        }
        dto.setUpdateTime(now);
        dto.setYn(1);
        return prodiumManager.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    @Override
    public List<ProdiumDto> findAll() {
        return prodiumManager.findAll();
    }

    @Override
    public List<ProdiumDto> findAllByCondition(ProdiumDto dto) {
        Assert.notNull(dto, "参数为空");
        return prodiumManager.findAllByCondition(dto);
    }
}
