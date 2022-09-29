package com.demo.springredisdemo;

import cn.hutool.json.JSONUtil;
import com.demo.springredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringRedisDemoApplicationTests {

    @Resource
    private StringRedisTemplate template;

    @Test
    void contextLoads() {
        String user = JSONUtil.toJsonStr(new User("昂问",22));
        template.opsForValue().set("user:2",user);
        System.out.println(JSONUtil.parse(template.opsForValue().get("user:2")).toBean(User.class));
    }

}
