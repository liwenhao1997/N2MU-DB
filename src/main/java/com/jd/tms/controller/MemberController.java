package com.jd.tms.controller;

import com.jd.tms.dto.CommonDto;
import com.jd.tms.dto.MemberDto;
import com.jd.tms.dto.ProfessorDto;
import com.jd.tms.exception.CommonException;
import com.jd.tms.service.MemberService;
import com.jd.tms.util.JacksonUtil;
import com.jd.tms.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 21:12
 */
@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public CommonDto<MemberDto> save(@RequestBody MemberDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("保存信息为空");
        }
        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授信息为空");
        }
        try {
            MemberDto save = memberService.save(dto);
            return CommonDto.constructWithNormalMessage("创建成功", save);
        } catch (CommonException ce) {
            return CommonDto.constructWithExpMessage(ce.getMessage());
        } catch (Exception e) {
            log.error("MemberController-save-error", e);
            return CommonDto.constructWithExpMessage("创建失败");
        }
    }

    @GetMapping
    public CommonDto<List<MemberDto>> findUserByCondition(MemberDto dto) {
        if (dto == null) {
            return CommonDto.constructWithWarnMessage("查询信息为空");
        }
        log.info(JacksonUtil.toJson(dto));

        if (StringUtil.isBlank(dto.getProfessorCode())) {
            return CommonDto.constructWithWarnMessage("教授编码为空");
        }
        List<MemberDto> res = memberService.findAllByCondition(dto);
        log.info(JacksonUtil.toJson(res));
        return CommonDto.constructWithNormalMessage("查询成功", res);
    }
}
