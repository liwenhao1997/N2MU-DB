package com.jd.tms.service;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.UserDto;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
public interface ProfessorService {
    ProfessorDto save(ProfessorDto dto);

    List<ProfessorDto> findAll();

    List<ProfessorDto> findAllByCondition(ProfessorDto dto);

}
