package com.jd.tms.controller;

import com.jd.tms.dto.CommonDto;
import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProdiumDto;
import com.jd.tms.exception.CommonException;
import com.jd.tms.service.MemberService;
import com.jd.tms.service.ProdiumService;
import com.jd.tms.service.ProfessorService;
import com.jd.tms.util.JacksonUtil;
import com.jd.tms.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 22:41
 */
@RestController
@RequestMapping("/prodium")
@Slf4j
public class ProdiumController {
    @Autowired
    private ProdiumService prodiumService;

    @PostMapping
    public CommonDto<ProdiumDto> save(@RequestBody ProdiumDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("保存信息为空");
        }
        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授信息为空");
        }
        try {
            ProdiumDto save = prodiumService.save(dto);
            return CommonDto.constructWithNormalMessage("创建成功", save);
        } catch (CommonException ce) {
            return CommonDto.constructWithExpMessage(ce.getMessage());
        } catch (Exception e) {
            log.error("MemberController-save-error", e);
            return CommonDto.constructWithExpMessage("创建失败");
        }
    }

    @GetMapping
    public CommonDto<List<ProdiumDto>> findUserByCondition(ProdiumDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("查询信息为空");
        }
        log.info(JacksonUtil.toJson(dto));

        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授编码为空");
        }
        List<ProdiumDto> res = prodiumService.findAllByCondition(dto);
        log.info(JacksonUtil.toJson(res));
        return CommonDto.constructWithNormalMessage("查询成功", res);
    }
}
