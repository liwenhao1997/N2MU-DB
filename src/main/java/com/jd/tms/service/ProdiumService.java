package com.jd.tms.service;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProdiumDto;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
public interface ProdiumService {
    ProdiumDto save(ProdiumDto dto);

    List<ProdiumDto> findAll();

    List<ProdiumDto> findAllByCondition(ProdiumDto dto);

}
