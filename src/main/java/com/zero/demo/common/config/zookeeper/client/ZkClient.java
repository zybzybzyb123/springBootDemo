package com.zero.demo.common.config.zookeeper.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.zero.demo.common.config.zookeeper.client.ZkConstant.BASE_SLEEP_TIME_MILLIS;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.CONNECTION_TIMEOUT_MILLIS;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.MAX_RETRIES;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.SESSION_TIMEOUT_MILLIS;
import static com.zero.demo.common.config.zookeeper.client.ZkConstant.ZK_SERVERS;

/**
 * @author zero
 * @created 2020/04/21
 */
public class ZkClient {

    private final RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME_MILLIS, MAX_RETRIES);
    private final CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString(ZK_SERVERS)
            .sessionTimeoutMs(SESSION_TIMEOUT_MILLIS)  // 会话超时时间
            .connectionTimeoutMs(CONNECTION_TIMEOUT_MILLIS) // 连接超时时间
            .retryPolicy(retryPolicy)
//            .namespace("test") // 包含隔离名称
            .build();
    {
        client.start();
    }

    public static void main(String[] args) {
        try {
            ZkClient zkClient = new ZkClient();
            String ans = new String(zkClient.client.getData().forPath("/zookeeper/config"));
            System.out.printf("ans=%s\n", ans);
        } catch (Exception e) {
            System.out.printf("e=%s\n", e);
        }

    }
}
