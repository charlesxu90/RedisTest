package com.mininglamp.emay.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by charles on 1/27/16.
 */
public class RedisDemo {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        //Connecting to Redis server on localhost
        System.out.println("Redis Java String Example=>");

        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));

        System.out.println("Redis Java List Example=>");

        //store data in redis list
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }

        //store data in redis list
        System.out.println("Redis Java Keys Example=>");

        // Get the stored data and print it
        List<String> listKeys = new ArrayList<String>(jedis.keys("*"));
        for(int i=0; i<listKeys.size(); i++) {
            System.out.println("List of stored keys:: "+listKeys.get(i));
        }

        jedis.set("BZ123456","123");
        jedis.set("BZ1223456",">123");
        jedis.set("BZ12344556",">>123");
        jedis.set("BZ12345618",">>>123");
        System.out.println("\nBefore storing a large array=>");
        System.out.println("Stored string in redis:: "+ jedis.get("BZ123456"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ1223456"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ12344556"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ12345618"));
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));
        for (int i = 0; i < 10000000; i++) { // with cache size 5MB
            jedis.set("test" + i, i + "");
        }
        System.out.println("\nAfter storing a large array=>");
        System.out.println("Stored string in redis:: "+ jedis.get("BZ123456"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ1223456"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ12344556"));
        System.out.println("Stored string in redis:: "+ jedis.get("BZ12345618"));
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));

    }
}
