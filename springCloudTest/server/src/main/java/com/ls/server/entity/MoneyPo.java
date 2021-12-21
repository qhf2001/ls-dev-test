package com.ls.server.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "money")
public class MoneyPo {
    private Integer id;

    private String name;

    private Long money;

    private Integer isDeleted;

    private Timestamp createAt;

    private Timestamp updateAt;
}
