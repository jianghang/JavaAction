package com.hangjiang.java8.defaultmethod;

import java.util.List;

/**
 * Created by jianghang on 2018/5/12.
 */
public class PageView<T> {

    private PageInfo pageInfo;

    private List<T> data;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
