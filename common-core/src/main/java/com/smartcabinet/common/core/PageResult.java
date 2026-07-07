package com.smartcabinet.common.core;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 统一分页返回对象，后台列表和小程序分页列表统一使用该结构。
 */
@Data
public class PageResult<T> {

    private Long total;
    private Long pageNum;
    private Long pageSize;
    private List<T> records;

    public static <T> PageResult<T> of(Long total, Long pageNum, Long pageSize, List<T> records) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setRecords(records == null ? Collections.emptyList() : records);
        return pageResult;
    }

    public static <T> PageResult<T> empty(Long pageNum, Long pageSize) {
        return of(0L, pageNum, pageSize, Collections.emptyList());
    }
}
