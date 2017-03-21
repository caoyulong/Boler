package edu.hlju.boler.pojo.vo;

import java.util.Map;

import edu.hlju.boler.datadictory.UserDataDict;

public class MapResponse extends StateResponse {
    private Map<Object, Object> map;

    public MapResponse(Map<Object, Object> map) {
        super(UserDataDict.OPERATIING_SUCCEED);
        this.map = map;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

}
