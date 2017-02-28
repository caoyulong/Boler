package edu.hlju.boler.pojo.vo;

import com.mysql.cj.api.x.Collection;

public class CollectionResponse extends BaseResponse {
    private Collection collection;

    public CollectionResponse(Collection collection) {
        super();
        this.collection = collection;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

}
