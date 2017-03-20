package edu.hlju.boler.pojo.vo;

import java.util.List;

import edu.hlju.boler.datadictory.UserDataDict;

public class ListResponse extends StateResponse {
    private List<? extends Object> list;

    public ListResponse(List<? extends Object> list) {
        super(UserDataDict.OPERATIING_SUCCEED);
        this.list = list;
    }

    public List<? extends Object> getList() {
        return list;
    }

    public void setList(List<? extends Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListResponse [list=" + list + "]";
    }

}
