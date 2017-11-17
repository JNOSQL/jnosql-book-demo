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


import org.jnosql.diana.api.Sort;
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentEntity;
import org.jnosql.diana.api.document.DocumentQuery;
import org.jnosql.diana.api.document.query.DocumentQueryBuilder;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.jnosql.diana.api.Sort.SortType.ASC;

public class DocumentQueryExample {

    public static void main(String[] args) {
        DocumentCondition nameEqualsAda = DocumentCondition.eq(Document.of("name", "Ada"));
        DocumentCondition youngerThan2Years = DocumentCondition.lt(Document.of("age", 2));
        DocumentCondition condition = nameEqualsAda.and(youngerThan2Years);
        DocumentCondition nameNotEqualsAda = nameEqualsAda.negate();

        DocumentCollectionManager manager = null;
        DocumentCollectionManagerAsync managerAsync = null;

        DocumentQuery query = DocumentQueryBuilder.select().from("collection").where("age")
                .lt(10).and("name").eq("Ada").
                        orderBy(Sort.of("name", ASC)).limit(10).start(2).build();

        List<DocumentEntity> entities = manager.select(query);
        Optional<DocumentEntity> entity = manager.singleResult(query);

        Consumer<List<DocumentEntity>> callback = e -> {};
        managerAsync.select(query, callback);
    }

    private DocumentQueryExample() {}
}
