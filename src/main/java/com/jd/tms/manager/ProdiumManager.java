package com.jd.tms.manager;

import com.jd.tms.dao.MemberDao;
import com.jd.tms.dao.ProdiumDao;
import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProdiumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:02
 */
@Component
public class ProdiumManager {

    @Autowired
    private ProdiumDao prodiumDao;

    /**
     * 保存用户信息
     * @param dto
     */
    public ProdiumDto save(ProdiumDto dto) {
        Assert.notNull(dto, "参数为空");
        return prodiumDao.save(dto);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public List<ProdiumDto> findAll() {
        return prodiumDao.findAll();
    }

    public List<ProdiumDto> findAllByCondition(ProdiumDto dto) {
        Assert.notNull(dto, "参数为空");
        return prodiumDao.findAllByCondition(dto);
    }

}
