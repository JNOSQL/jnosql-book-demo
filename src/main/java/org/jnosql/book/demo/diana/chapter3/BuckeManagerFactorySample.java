package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueEntity;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BuckeManagerFactorySample {


    public static void main(String[] args) {
        BucketManagerFactory bucketManager= null;

        BucketManager bucket = bucketManager.getBucketManager("bucket");

        List<String> list = bucketManager.getList("list", String.class);
        Set<String> set = bucketManager.getSet("set", String.class);
        Queue<String> queue = bucketManager.getQueue("queue", String.class);
        Map<String, String> map = bucketManager.getMap("map", String.class, String.class);


    }
}
