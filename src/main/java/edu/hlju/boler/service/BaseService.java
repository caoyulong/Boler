package edu.hlju.boler.service;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import edu.hlju.boler.common.ResponseFactory;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.vo.CollectionResponse;
import edu.hlju.boler.pojo.vo.MapResponse;
import edu.hlju.boler.pojo.vo.StateResponse;

public abstract class BaseService {
    @Resource
    private ResponseFactory responseFactory;

    protected CollectionResponse getResponse(Collection<Object> collection) {
        return responseFactory.getResponse(collection);
    }

    protected MapResponse getResponse(Map<Object, Object> map) {
        return responseFactory.getResponse(map);
    }

    protected StateResponse getResponse(UserDataDict userDataDict) {
        return responseFactory.getResponse(userDataDict);
    }

}
