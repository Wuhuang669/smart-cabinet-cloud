package com.smartcabinet.common.enums;

/**
 * 状态枚举基础接口，所有业务状态枚举必须实现该接口，避免代码中散落魔法值。
 */
public interface BaseStatusEnum {

    /**
     * 状态编码，通常对应数据库中的 char(1) 或 varchar 状态字段。
     */
    String getCode();

    /**
     * 状态中文说明，用于日志、接口文档和后台展示。
     */
    String getDescription();
}
