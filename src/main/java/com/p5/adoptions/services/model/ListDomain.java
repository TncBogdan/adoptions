package com.p5.adoptions.services.model;

import java.util.List;

public class ListDomain<T> {

    private Integer totalCount;
    private List<T> list;

    public ListDomain(Integer totalCount, List<T> list) {
        this.totalCount = totalCount;
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public ListDomain<T> setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public ListDomain<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
}
