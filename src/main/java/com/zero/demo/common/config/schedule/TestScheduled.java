package com.zero.demo.common.config.schedule;/**
 * @author zero
 * @created on 2020/5/9
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zero
 * @created 2020/05/09
 */
@Service
@Slf4j
public class TestScheduled {

    @Scheduled(cron = "* */2 * * * *")
    private void test() {

    }
}
