package com.ninexlabs.lgdp.commons.utils;

import java.util.ArrayList;
import java.util.List;

public class ListOfObjects<T> {

    private List<T> list;

    ListOfObjects() {
        this.list = new ArrayList<T>();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
