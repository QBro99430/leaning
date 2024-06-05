package com.quicksand.base.model;

import lombok.Data;
import lombok.ToString;

/**
 * 分页查询通用参数
 */
@Data
@ToString
public class PageParams {

    //当前页码
    private Long PageNo = 1L;

    //每页记录数默认值
    private Long pageSize = 10L;

    public PageParams(Long pageNo, Long pageSize) {
        this.PageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageParams() {
    }
}
