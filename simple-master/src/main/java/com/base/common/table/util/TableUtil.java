package com.base.common.table.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.common.table.entity.TablePage;
import com.base.common.table.entity.TableResponse;

import java.util.List;

public class TableUtil {

    public static  <T> Page<T> buildPageRequest(TablePage tablePage){

        Long current = 1L;
        Long size = 10L;

        if(tablePage == null){
            return null;
        }
        if(tablePage.getCurrentPage() != null){
            current = tablePage.getCurrentPage();
        }
        if(tablePage.getPageSize() != null){
            size = tablePage.getPageSize();
        }

        Page<T> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return page;
    }

    public static TableResponse buildPageResponse(IPage<?> result){

        if(result == null){
            return null;
        }

        TablePage page = new TablePage();
        page.setCurrentPage(result.getCurrent());
        page.setPageSize(result.getSize());
        page.setPages(result.getPages());
        page.setTotal(result.getTotal());

        return new TableResponse(page,result.getRecords());
    }

}
