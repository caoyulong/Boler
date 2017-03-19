package edu.hlju.boler.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.vo.ListResponse;
import edu.hlju.boler.pojo.vo.MapResponse;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.ValueResponse;

@Component
public class ResponseFactory {

    public ListResponse getResponse(List<? extends Object> list) {
        return new ListResponse(list);
    }

    public MapResponse getResponse(Map<? extends Object, ? extends Object> map) {
        return new MapResponse(map);
    }

    public ValueResponse getResponse(Object value) {
        return new ValueResponse(value);
    }

    public StateResponse getResponse(UserDataDict userDataDict) {
        return new StateResponse(userDataDict);
    }

}
