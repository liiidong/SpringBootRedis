package com.enough.learn.learn.redis.controller;

import com.enough.learn.learn.redis.entity.MessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import java.util.UUID;

/**
 * @program: learn-redis
 * @description:
 * @author: lidong
 * @create: 2019/11/15
 */
public abstract class BaseController<T> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MessageResult <T> getMessageResult(String msg, MessageResult.Status status, T data, String newResource) {
        MessageResult <T> result = new MessageResult <>();
        result.setMsg(msg);
        result.setStatus(status);
        result.setData(data);
        result.setNewResource(newResource);
        return result;
    }

    public ModelMap getModelMap(String status, Object data, String msg) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("status", status);
        modelMap.put("data", data);
        modelMap.put("msg", msg);
        return modelMap;

    }

    public String createUuid() {
        //获取UUID并转化为String对象
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

}
