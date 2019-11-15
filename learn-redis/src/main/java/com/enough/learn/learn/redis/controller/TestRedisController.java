package com.enough.learn.learn.redis.controller;

import com.enough.learn.learn.redis.entity.MessageResult;
import com.enough.learn.learn.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: learn-redis
 * @description: 测试资源类
 * @author: lidong
 * @create: 2019/11/15
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestRedisController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping(path = "/redis")
    public MessageResult <String> addRedisData(@RequestBody Map <String, String> map) {
        for (String key : map.keySet()) {
            log.info("添加结果：" + redisUtil.setnx(key, map.get(key)));
        }
        return getMessageResult("添加成功！", MessageResult.Status.SUCCESS, null, StringUtils.EMPTY);
    }

    @DeleteMapping(path = "/redis/{key}")
    public MessageResult <String> deleteRedisData(@PathVariable String key) {
        log.info("删除结果：" + redisUtil.del(key));
        return getMessageResult("删除成功！", MessageResult.Status.SUCCESS, null, StringUtils.EMPTY);
    }

}
