package com.sparta.spartascheduler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
        //(exclude =  SecurityAutoConfiguration .class )//시큐리티 제외
class SpartaSchedulerApplicationTests {

    @Test
    void contextLoads() {
    }

}
