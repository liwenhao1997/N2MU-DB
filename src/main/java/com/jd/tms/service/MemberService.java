package com.jd.tms.service;

import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProfessorDto;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
public interface MemberService {
    MemberDto save(MemberDto dto);

    List<MemberDto> findAll();

    List<MemberDto> findAllByCondition(MemberDto dto);

}
