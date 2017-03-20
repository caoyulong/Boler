package edu.hlju.boler.pojo.vo;

import java.util.Map;

import edu.hlju.boler.datadictory.UserDataDict;

public class MapResponse extends StateResponse {
    private Map<? extends Object, ? extends Object> map;

    public MapResponse(Map<? extends Object, ? extends Object> map) {
        super(UserDataDict.OPERATIING_SUCCEED);
        this.map = map;
    }

    public Map<? extends Object, ? extends Object> getMap() {
        return map;
    }

    public void setMap(Map<? extends Object, ? extends Object> map) {
        this.map = map;
    }

}
