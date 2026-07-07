package com.smartcabinet.common.enums;

import lombok.Getter;

/**
 * 软删除状态枚举，统一所有业务表的 del_flag 字段含义。
 */
@Getter
public enum DelFlagEnum implements BaseStatusEnum {

    NORMAL("0", "未删除"),
    DELETED("1", "已删除");

    private final String code;
    private final String description;

    DelFlagEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
