package com.jd.tms.controller;

import com.jd.tms.dto.CommonDto;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.dto.UserDto;
import com.jd.tms.exception.CommonException;
import com.jd.tms.service.ProfessorService;
import com.jd.tms.util.JacksonUtil;
import com.jd.tms.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 16:40
 */
@RestController
@RequestMapping("professor")
@Slf4j
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public CommonDto<ProfessorDto> save(@RequestBody ProfessorDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("保存信息为空");
        }
        if (StringUtil.isBlank(dto.getName())) {
            return CommonDto.constructWithWarnMessage("用户名为空");
        }
        try {
            ProfessorDto save = professorService.save(dto);
            return CommonDto.constructWithNormalMessage("创建成功", save);
        } catch (CommonException ce) {
            return CommonDto.constructWithExpMessage(ce.getMessage());
        } catch (Exception e) {
            log.error("ProfessorController-save-error", e);
            return CommonDto.constructWithExpMessage("创建失败");
        }
    }

    @GetMapping
    public CommonDto<List<ProfessorDto>> findUserByCondition(ProfessorDto dto) {
        log.info(JacksonUtil.toJson(dto));
        List<ProfessorDto> res = professorService.findAllByCondition(dto);
        log.info(JacksonUtil.toJson(res));
        return CommonDto.constructWithNormalMessage("查询成功", res);
    }

}
