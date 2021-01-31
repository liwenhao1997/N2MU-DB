package com.jd.tms.dto;

import com.jd.tms.anotation.AutoIncrement;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 16:27
 */
@Data
@Document("research_topic")
public class ResearchTopicDto {
    @Id
    @AutoIncrement
    private Long id;
    private String professorCode;
    private String name;
    private String img;
    private String desc;
    private String style;

    private Date createTime;
    private Date updateTime;

    private Integer yn;
}
