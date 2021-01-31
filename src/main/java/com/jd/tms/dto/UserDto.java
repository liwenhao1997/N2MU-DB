package com.jd.tms.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.management.counter.perf.PerfInstrumentation;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liwenhao
 * @Date: 2021/1/23 14:05
 */
@Data
@Document("user")
public class UserDto implements Serializable {
    @Id
    private String id;

    private String userName;

    private String userCode;

    private String userPhone;

    private Integer userRole;

    private String email;

    private Date createTime;

    private Date updateTime;
    private Integer yn;

}
