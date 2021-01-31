package com.jd.tms.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: liwenhao
 * @Date: 2021/1/24 18:09
 */
@Document("sequence")
@Data
public class SequenceDto {
    @Id
    private String id;			//主键
    private String collName;	//集合名称
    private long seqId;
}
