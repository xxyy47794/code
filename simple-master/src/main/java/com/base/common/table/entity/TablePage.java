package com.base.common.table.entity;

import lombok.Data;

@Data
public class TablePage {

    private Long currentPage;

    private Long pageSize;

    private Long total;

    private Long pages;

}
