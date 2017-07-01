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


import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnEntity;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsync;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ColumnManagerExample {

    public static void main(String[] args) {
        ColumnEntity entity = ColumnEntity.of("columnFamily");
        Column diana = Column.of("name", "Diana");
        entity.add(diana);

        List<ColumnEntity> entities = Collections.singletonList(entity);
        ColumnFamilyManager manager = null;

        ColumnFamilyManagerAsync managerAsync = null;

        //insert operations
        manager.insert(entity);
        manager.insert(entity, Duration.ofHours(2L));//saves with 2 hours of TTL
        manager.insert(entities, Duration.ofHours(2L));//saves with 2 hours of TTL
        //updates operations
        manager.update(entity);
        manager.update(entities);


        //insert operations
        managerAsync.insert(entity);
        managerAsync.insert(entity, Duration.ofHours(2L));//saves with 2 hours of TTL
        managerAsync.insert(entities, Duration.ofHours(2L));//saves with 2 hours of TTL
        //updates operations
        managerAsync.update(entity);
        managerAsync.update(entities);

        //callback
        Consumer<ColumnEntity> callBack = e -> {
        };
        managerAsync.insert(entity, callBack);
        managerAsync.update(entity, callBack);

    }

    private ColumnManagerExample() {}
}
