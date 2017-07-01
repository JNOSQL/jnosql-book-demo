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


import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentEntity;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class DocumentManagerExample {

    public static void main(String[] args) {
        DocumentEntity entity = DocumentEntity.of("collection");
        Document diana = Document.of("name", "Diana");
        entity.add(diana);

        List<DocumentEntity> entities = Collections.singletonList(entity);
        DocumentCollectionManager manager = null;

        DocumentCollectionManagerAsync managerAsync = null;

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
        Consumer<DocumentEntity> callBack = e -> {
        };
        managerAsync.insert(entity, callBack);
        managerAsync.update(entity, callBack);

    }
}
