package edu.hlju.boler.pojo.vo;

public class ValueResponse extends BaseResponse {
    private Object value;

    public ValueResponse(Object value) {
        super();
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
