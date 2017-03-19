package edu.hlju.boler.pojo.vo;

import java.util.Map;

public class MapResponse extends BaseResponse {
    private Map<? extends Object, ? extends Object> map;

    public MapResponse(Map<? extends Object, ? extends Object> map) {
        super();
        this.map = map;
    }

    public Map<? extends Object, ? extends Object> getMap() {
        return map;
    }

    public void setMap(Map<? extends Object, ? extends Object> map) {
        this.map = map;
    }

}
