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
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DocumentEntityApp {

    public static void main(String[] args) {

        DocumentEntity entity = DocumentEntity.of("collection");
        String name = entity.getName();
        entity.add(Document.of("id", Value.of(10L)));
        entity.add(Document.of("version", 0.001));
        entity.add(Document.of("name", "Diana"));
        entity.add(Document.of("options", Arrays.asList(1, 2, 3)));

        List<Document> documents = entity.getDocuments();
        Optional<Document> id = entity.find("id");
        entity.remove("options");
    }

    private DocumentEntityApp() {}
}
