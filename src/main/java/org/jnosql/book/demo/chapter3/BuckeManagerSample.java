/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package org.jnosql.book.demo.chapter3;


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
