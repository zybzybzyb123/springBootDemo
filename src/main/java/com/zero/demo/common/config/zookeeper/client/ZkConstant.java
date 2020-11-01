package com.zero.demo.common.config.zookeeper.client;

/**
 * @author zero
 * @created 2020/04/21
 */
public interface ZkConstant {

    int BASE_SLEEP_TIME_MILLIS = 1000;
    int MAX_RETRIES = 3;

    String ZK_SERVERS = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    int SESSION_TIMEOUT_MILLIS = 5000;
    int CONNECTION_TIMEOUT_MILLIS = 5000;

}
