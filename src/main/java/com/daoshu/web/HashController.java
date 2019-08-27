package com.daoshu.web;

import com.daoshu.entity.Student;
import com.daoshu.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "2.测试redis Hash", description = "测试redis Hash")
@RestController
@RequestMapping("/hash")
public class HashController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(notes = "设置map放入", value = "设置hash")
    @GetMapping("/setMap")
    public String setMap(String key) {
        Map map = new HashMap();
        Student s = new Student();
        s.setName("张三");
        s.setAge(20);
        map.put("key", "学生信息");
        map.put("stu", s);
        redisUtil.hmset(key, map);
        return "ok";
    }

    @ApiOperation(notes = "设置hash单个值", value = "设置hash单个值")
    @GetMapping("setkey")
    public boolean setkey(String key, String item) {
        boolean b = redisUtil.hset(key, item, "放一个参数值");
        return b;
    }

    @ApiOperation(notes = "获得单个的值", value = "获得单个的值")
    @GetMapping("/getkey")
    public Object getkey(String key, String item) {
        Object r = redisUtil.hget(key, item);
        return r;
    }

    @ApiOperation(notes = "获得hash中map的值", value = "获得hash中map的值")
    @GetMapping("/getMap")
    public Map getMap(String key) {
        Map<Object, Object> r = redisUtil.hmget(key);
        return r;
    }

    @ApiOperation(notes = "存储map并设置时间", value = "存储map并设置时间")
    @GetMapping("/setMapTime")
    public void setMapTime(String key, Long time) {
        Map map = new HashMap();
        Student s = new Student();
        s.setName("张三");
        s.setAge(20);
        map.put("key", "学生信息");
        map.put("stu", s);
        redisUtil.hmset(key, map, time);
    }

    @ApiOperation(value = "获得有效期", notes = "获得有效期")
    @GetMapping("/getExpireTime")
    public long getExpireTime(String key) {
        long time = redisUtil.getExpire(key);
        return time;
    }

    @ApiOperation(value = "刷新有效期", notes = "刷新有效期")
    @GetMapping("/expireTime")
    public boolean expire(String key, long time) {
        boolean b = redisUtil.expire(key, time);
        return b;
    }

    @ApiOperation(value = "设置单个值得并设置有效期", notes = "设置单个值得并设置有效期")
    @GetMapping("/hsetkeyTime")
    public void hsetkeyTime(String key, String item, String value, Long time) {
        redisUtil.hset(key, item, value, time);
    }

    @ApiOperation(value = "判断是否有值", notes = "判断是否有值")
    @GetMapping("/isHash")
    public boolean isHash(String key, String item) {
        boolean f = false;
        f = redisUtil.hHasKey(key, item);
        return f;
    }

    @ApiOperation(value = "删除hash表中的值", notes = "删除hash表中的值")
    @GetMapping("/hdel")
    public String hdel(String key, String item) {
        redisUtil.hdel(key, item);
        return "ok";
    }


}
