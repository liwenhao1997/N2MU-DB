package com.jd.tms.controller;

import com.jd.tms.dto.CommonDto;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.ResearchTopicDto;
import com.jd.tms.exception.CommonException;
import com.jd.tms.service.ProfessorService;
import com.jd.tms.service.ResearchTopicService;
import com.jd.tms.util.JacksonUtil;
import com.jd.tms.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 17:55
 */
@RestController
@RequestMapping("/researchTopic")
@Slf4j
public class ResearchTopicController {
    @Autowired
    private ResearchTopicService researchTopicService;

    @PostMapping
    public CommonDto<ResearchTopicDto> save(@RequestBody ResearchTopicDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("保存信息为空");
        }
        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授编码为空");
        }
        try {
            ResearchTopicDto save = researchTopicService.save(dto);
            return CommonDto.constructWithNormalMessage("创建成功", save);
        } catch (CommonException ce) {
            return CommonDto.constructWithExpMessage(ce.getMessage());
        } catch (Exception e) {
            log.error("ProfessorController-save-error", e);
            return CommonDto.constructWithExpMessage("创建失败");
        }
    }

    @GetMapping
    public CommonDto<List<ResearchTopicDto>> findAllByCondition(ResearchTopicDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("查询信息为空");
        }
        log.info(JacksonUtil.toJson(dto));

        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授编码为空");
        }
        List<ResearchTopicDto> res = researchTopicService.findAllByCondition(dto);
        log.info(JacksonUtil.toJson(res));
        return CommonDto.constructWithNormalMessage("查询成功", res);
    }
}
