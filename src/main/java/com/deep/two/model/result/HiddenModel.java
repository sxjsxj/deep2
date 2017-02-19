package com.deep.two.model.result;

import java.util.ArrayList;
import java.util.List;

public class HiddenModel {
    private List<String> list = new ArrayList<String>();
    private String userId;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
