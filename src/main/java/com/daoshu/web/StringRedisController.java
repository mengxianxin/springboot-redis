package com.daoshu.web;

import com.daoshu.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/test", tags = "1.测试redis String", description = "测试redis String")
@RestController
public class StringRedisController {
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "设置key", notes = "设置key")
    @GetMapping("/setKey")
    public String setKey(String key, String value) {
        redisUtil.set(key, value);
        return "ok";
    }

    @ApiOperation(value = "获得key值", notes = "获得key值")
    @GetMapping("/getkey")
    public String getValue(String key) {
        String value = (String) redisUtil.get(key);
        return value;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @GetMapping("/delKey")
    public String delKey(String key) {
        redisUtil.delkey(key);
        return "ok";
    }

    @ApiOperation(value = "设置有效期", notes = "设置有效期")
    @GetMapping("/setTime")
    public boolean setTime(String key,String value, long time) {
        boolean b = redisUtil.set(key, value, time);
        return b;
    }

    @ApiOperation(value = "刷新有效期", notes = "刷新有效期")
    @GetMapping("/expireTime")
    public boolean expire(String key, long time) {
        boolean b = redisUtil.expire(key, time);
        return b;
    }

    @ApiOperation(value = "获得有效期", notes = "获得有效期")
    @GetMapping("/getExpireTime")
    public long getExpireTime(String key) {
        long time = redisUtil.getExpire(key);
        return time;
    }










}
