package com.jd.tms.dto;

import com.jd.tms.anotation.AutoIncrement;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 21:02
 */
@Document("member")
@Slf4j
@Data
public class MemberDto {

    @Id
    @AutoIncrement
    private Long id;

    private String professorCode;

    private String name;

    private String img;

    private String year;

    private String researchTopic;

    private String afterGraduate;

    private Integer show;

    /**
     * 10-本科生
     * 20-研究生
     */
    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer yn;
}
