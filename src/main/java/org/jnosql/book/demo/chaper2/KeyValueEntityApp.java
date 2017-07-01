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

package org.jnosql.book.demo.chaper2;


import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.key.KeyValueEntity;

public class KeyValueEntityApp {

    public static void main(String[] args) {
        KeyValueEntity<String> entity = KeyValueEntity.of("key", Value.of(123));
        KeyValueEntity<Integer> entity2 = KeyValueEntity.of(12, "Text");
        String key = entity.getKey();
        Value value = entity.getValue();
        Integer integer = entity.get(Integer.class);

    }
}
