package com.zero.demo.common.config.zookeeper.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import static com.zero.demo.common.config.zookeeper.client.ZkConstant.BASE_SLEEP_TIME_MILLIS;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.CONNECTION_TIMEOUT_MILLIS;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.MAX_RETRIES;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.SESSION_TIMEOUT_MILLIS;

/**
 * @author zero
 * @created 2020/04/21
 */
public class ZkClient {


    private static RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME_MILLIS, MAX_RETRIES);
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.01:2181")
            .sessionTimeoutMs(SESSION_TIMEOUT_MILLIS)  // 会话超时时间
            .connectionTimeoutMs(CONNECTION_TIMEOUT_MILLIS) // 连接超时时间
            .retryPolicy(retryPolicy)
//            .namespace("test") // 包含隔离名称
            .build();
    static {
        client.start();
    }

    public static void main(String[] args) {
        try {
            String ans = new String(client.getData().forPath("/brokers"));
            System.out.printf("ans=%s\n", ans);
        } catch (Exception e) {
            System.out.printf("e=%s\n", e);
        }

    }
}
