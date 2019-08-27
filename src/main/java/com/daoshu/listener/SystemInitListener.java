package com.daoshu.listener;

import com.daoshu.utils.RedisUtil;
import com.daoshu.utils.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Administrator
 * @package com.kedacom.dzjz.listener
 * @date 2018/10/17
 * @description: 初始化完成后启动
 */
@Slf4j
@Order(value = 2)
@Component
public class SystemInitListener implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("项目启动了，删除缓存中的数据");
        RedisUtil redisUtil = SpringBeanUtils.getObject("redisUtil");
        Set keys = redisUtil.keys("*");
        log.info("keys:{}",keys);
//        if (keys != null && !keys.isEmpty()) {
//            redisUtil.delkeys(keys);
//        }



    }
}
