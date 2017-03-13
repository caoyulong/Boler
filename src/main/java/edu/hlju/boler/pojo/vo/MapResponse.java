package edu.hlju.boler.pojo.vo;

import java.util.Map;

public class MapResponse extends BaseResponse {
    private Map<Object, Object> map;

    public MapResponse(Map<Object, Object> map) {
        super();
        this.map = map;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

}
