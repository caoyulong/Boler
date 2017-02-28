package edu.hlju.boler.pojo.vo;

import java.util.Map;

public class MapResponse extends BaseResponse {
    private Map<String, Object> map;

    public MapResponse(Map<String, Object> map) {
        super();
        this.map = map;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

}
