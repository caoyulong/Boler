package edu.hlju.boler.common;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.vo.CollectionResponse;
import edu.hlju.boler.pojo.vo.MapResponse;
import edu.hlju.boler.pojo.vo.StateResponse;

@Component
public class ResponseFactory {

    public CollectionResponse getResponse(Collection<Object> collection) {
        return new CollectionResponse(collection);
    }

    public MapResponse getResponse(Map<Object, Object> map) {
        return new MapResponse(map);
    }

    public StateResponse getResponse(UserDataDict userDataDict) {
        return new StateResponse(userDataDict);
    }

}
