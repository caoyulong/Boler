package edu.hlju.boler.pojo.vo;

import java.util.Collection;

public class CollectionResponse extends BaseResponse {
    private Collection<Object> collection;

    public CollectionResponse(Collection<Object> collection) {
        super();
        this.collection = collection;
    }

    public Collection<Object> getCollection() {
        return collection;
    }

    public void setCollection(Collection<Object> collection) {
        this.collection = collection;
    }

}
