package com.jd.tms.dto;

import com.jd.tms.anotation.AutoIncrement;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 21:50
 */
@Data
@Document("prodium")
public class ProdiumDto {
    @Id
    @AutoIncrement
    private Long id;
    private String professorCode;
    private String author;
    private String title;
    private String year;
    private String level;
    private String periodical;
    private String authorLevel;
    private Integer pre;
    private Date createTime;

    private Date updateTime;

    private Integer yn;
}
