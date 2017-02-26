package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.KeyValueEntity;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class BuckeManagerSample {


    public static void main(String[] args) {
        BucketManager bucketManager= null;

        KeyValueEntity<String> entity = KeyValueEntity.of("key", 1201);
        Set<KeyValueEntity<String>> entities = Collections.singleton(entity);
        bucketManager.put("key", "value");
        bucketManager.put(entity);
        bucketManager.put(entities);
        bucketManager.put(entities, Duration.ofHours(2));//two hours TTL
        bucketManager.put(entity, Duration.ofHours(2));//two hours TTL


        Optional<Value> value = bucketManager.get("key");
        Iterable<Value> values = bucketManager.get(Collections.singletonList("key"));
        bucketManager.remove("key");
        bucketManager.remove(Collections.singletonList("key"));

    }
}
