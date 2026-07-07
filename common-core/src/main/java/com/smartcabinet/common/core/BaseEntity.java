package com.smartcabinet.common.core;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础实体字段，所有业务表实体优先继承该类。
 */
@Data
public class BaseEntity {

    private Long id;
    private String uid;
    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;
    private String delFlag;
    private String remarks;
}
