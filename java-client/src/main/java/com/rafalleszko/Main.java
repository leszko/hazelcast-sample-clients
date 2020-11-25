package com.rafalleszko;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress(String.format("%s:5701", System.getenv("HZ_HOST")));
        HazelcastInstance hazelcast = HazelcastClient.newHazelcastClient(config);
        IMap<Integer, Integer> map = hazelcast.getMap("map");

        while (true) {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Inserting: " + i);
                try {
                    map.put(i, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Thread.sleep(1000);
        }
    }
}
