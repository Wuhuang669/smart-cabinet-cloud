package com.smartcabinet.common.util;

import java.util.UUID;

/**
 * 业务 UID 生成工具，后续所有业务表的 uid 字段可以统一使用该工具生成。
 */
public final class UidUtil {

    private UidUtil() {
    }

    public static String newUid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
