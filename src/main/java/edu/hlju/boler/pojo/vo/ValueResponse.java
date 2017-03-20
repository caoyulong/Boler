package edu.hlju.boler.pojo.vo;

import edu.hlju.boler.datadictory.UserDataDict;

public class ValueResponse extends StateResponse {
    private Object value;

    public ValueResponse(Object value) {
        super(UserDataDict.OPERATIING_SUCCEED);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueResponse [value=" + value + "]";
    }

}
