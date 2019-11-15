package com.enough.learn.learn.redis.entity;

import java.io.Serializable;

/**
 * @program: learn-redis
 * @description:
 * @author: lidong
 * @create: 2019/11/15
 */
public class MessageResult<T> implements Serializable {

    private static final long serialVersionUID = -1393104860022774284L;

    private String msg;
    private Status status;
    private T data;
    private String newResource;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getNewResource() {
        return newResource;
    }

    public void setNewResource(String newResource) {
        this.newResource = newResource;
    }

    public static enum Status {
        SUCCESS, FAULT;
    }
}
