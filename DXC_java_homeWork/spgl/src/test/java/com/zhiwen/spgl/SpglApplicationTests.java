package com.zhiwen.spgl;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class SpglApplicationTests {



    @Test
    void contextLoads() {
    }

    @Test
    void Logtest() {

    }

}

class Logtest {

    static final Logger log =  LoggerFactory.getLogger(Logtest.class);
    @Test
    void func1() {

        log.trace("这是一条TRACE日志");
        log.debug("这是一条DEBUG日志");
        log.info("这是一条INFO日志");
        log.warn("这是一条WARN日志");
        log.error("这是一条ERROR日志");
    }
}
