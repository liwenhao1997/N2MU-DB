package com.jd.tms.dto;

import com.jd.tms.anotation.AutoIncrement;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 16:07
 */
@Document("professor")
@Data
public class ProfessorDto {

    @Id
    @AutoIncrement
    private Long id;
    private String code;
    private String name;
    private String title;
    private String img;
    private String desc;
    private ContactDto contactInfo;
    private List<ResearchTopicDto> researchTopicList;
    private LabDto lab;

    private Date createTime;
    private Date updateTime;
    private Integer yn;
}
