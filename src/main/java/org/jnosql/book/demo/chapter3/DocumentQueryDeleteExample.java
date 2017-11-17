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


import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentDeleteQuery;
import org.jnosql.diana.api.document.query.DocumentQueryBuilder;

public class DocumentQueryDeleteExample {

    public static void main(String[] args) {


        DocumentCollectionManager manager = null;
        DocumentCollectionManagerAsync managerAsync = null;

        DocumentDeleteQuery query = DocumentQueryBuilder.delete().from("collection").where("age").gt(10)
                .build();


        manager.delete(query);

        managerAsync.delete(query);
        managerAsync.delete(query, v -> {
        });
    }

    private DocumentQueryDeleteExample() {
    }
}
