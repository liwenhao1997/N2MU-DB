package com.jd.tms.service;

import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.ResearchTopicDto;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:01
 */
public interface ResearchTopicService {
    ResearchTopicDto save(ResearchTopicDto dto);

    List<ResearchTopicDto> findAll();

    List<ResearchTopicDto> findAllByCondition(ResearchTopicDto dto);

}
