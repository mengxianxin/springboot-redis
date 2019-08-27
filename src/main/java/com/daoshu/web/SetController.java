package com.daoshu.web;

import com.daoshu.entity.Student;
import com.daoshu.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Api(tags = "3.测试redis Set", description = "测试redis Set")
@RestController
@RequestMapping("/set")
public class SetController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "设置单个的", notes = "设置单个的")
    @GetMapping("/sSet")
    public String sSet(String key) {
        Student s = new Student();
        s.setAge(20);
        s.setName("设置set值");
        redisUtil.sSet(key, s, "张三", 10, "lisi");
        return "ok";
    }

    @ApiOperation(value = "获取set里的值", notes = "获取set里的值")
    @GetMapping("/sGet")
    public Map sGet(String key) {
        Map map = new HashMap();
        Set<Object> r = redisUtil.sGet(key);
        map.put("r", r);
        return map;
    }


    //sHasKey

    @ApiOperation(value = "判断某个值是否存在", notes = "判断某个值是否存在")
    @GetMapping("/sHasKey")
    public boolean sHasKey(String key) {
        boolean f = false;
        Student s = new Student();
        s.setAge(20);
        s.setName("设置set值");
        f = redisUtil.sHasKey(key,s);
        return f;
    }

    @ApiOperation(value = "得到set长度", notes = "得到set长度")
    @GetMapping("/sGetSetSize")
    public Long sGetSetSize(String key) {
        long r = redisUtil.sGetSetSize(key);
        return r;
    }

    @ApiOperation(value = "删除多个值", notes = "删除多个值")
    @GetMapping("/setRemove")
    public long setRemove(String key,Integer value){
        Student s = new Student();
        s.setAge(20);
        s.setName("设置set值");
        long r = redisUtil.setRemove(key, value,s);
        return r;
    }

    @ApiOperation(value = "设置有效期", notes = "设置有效期")
    @GetMapping("/sSetAndTime")
    public String sSetAndTime(String key, long time) {
        redisUtil.sSetAndTime(key,time,"张三",10,0.89);
        return "ok";
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
