package com.jd.tms.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 21:32
 */
@Data
public class LabDto {
    private List<String> imgs;
    private List<Info> info;
}

@Data
class Info {
    private String title;

    private String content;
}
