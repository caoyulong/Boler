package edu.hlju.boler.pojo.vo;

import java.util.List;

public class ListResponse extends BaseResponse {
    private List<? extends Object> list;

    public ListResponse(List<? extends Object> list) {
        super();
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
