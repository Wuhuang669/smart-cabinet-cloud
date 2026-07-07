package com.smartcabinet.common.util;

import java.util.UUID;

/**
 * 日志链路追踪工具，后续网关和各服务过滤器统一使用该工具生成 traceId。
 */
public final class TraceIdUtil {

    public static final String TRACE_ID_HEADER = "X-Trace-Id";

    private TraceIdUtil() {
    }

    public static String newTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
