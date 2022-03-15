package com.example.demoShoeShop.Utils;

public class ResponseBodyStandard {
    private int status;
    private Object object;

    public ResponseBodyStandard(int status, Object object) {
        this.status = status;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
