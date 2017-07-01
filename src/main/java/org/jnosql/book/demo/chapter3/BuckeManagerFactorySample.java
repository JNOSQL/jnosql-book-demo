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


import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.api.key.BucketManagerFactory;

import java.util.List;
import java.util.Map;
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

    private BuckeManagerFactorySample() {}
}
