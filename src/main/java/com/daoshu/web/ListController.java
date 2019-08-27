package com.daoshu.web;

import com.daoshu.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "/test", tags = "4.测试redis list", description = "测试redis list")
@RestController
public class ListController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "从右侧放入",notes = "从右侧放入")
    @GetMapping("/lSet")
    public String lSet(String key,String value) {
        redisUtil.lSet(key,value);
        return "ok";
    }

    @ApiOperation(value = "从左侧放入并设置有效期",notes = "从左侧放入并设置有效期")
    @GetMapping("/llPush")
    public String llPush(String key,String value, long time) {
        redisUtil.llPush(key,value, time);
        return "ok";
    }

    @ApiOperation(value = "放入list集合",notes = "放入list集合")
    @GetMapping("/lrPushAll")
    public String lrPushAll(String key) {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("2");
        list.add(3.0);
        redisUtil.lrPushAll(key, list);
        return "ok";
    }


    @ApiOperation(value = "得到值", notes = "得到值")
    @GetMapping("/lGet")
    public Map lGet(String key, long start, long end) {
        Map map = new HashMap();
        List<Object> r = redisUtil.lGet(key, start, end);
        map.put("r",r);
        return map;
    }

    @ApiOperation(value = "获取list缓存的长度",notes = "获取list缓存的长度")
    @GetMapping("/lGetListSize")
    public long lGetListSize(String key) {
        return redisUtil.lGetListSize(key);
    }

    @ApiOperation(value = "通过索引获取list中的值",notes = "通过索引获取list中的值")
    @GetMapping("/lGetIndex")
    public Map lGetIndex(String key, long index) {
        Map map = new HashMap();
        Object r = redisUtil.lGetIndex(key, index);
        map.put("r",r);
        return map;
    }

    @ApiOperation(value = "根据索引修改list中的某条数据",notes = "根据索引修改list中的某条数据")
    @GetMapping("/lUpdateIndex")
    public String lUpdateIndex(String key, long index, String value) {
       redisUtil.lUpdateIndex(key, index, value);
        return "ok";
    }

    @ApiOperation(value = "移除N个值为value",notes = "移除N个值为value")
    @GetMapping("/lRemove")
    public long lRemove(String key, long count, String value) {
        long l = redisUtil.lRemove(key, count, value);
        return l;
    }




}
