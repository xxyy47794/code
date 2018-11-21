package com.base.common.table.entity;

import lombok.Data;

import java.util.List;

@Data
public class TableResponse {

    private TablePage page;

    private List<?> content;

    public TableResponse(TablePage page,List<?> content){
        this.page = page;
        this.content = content;
    }

}
