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


import org.jnosql.diana.api.TypeReference;
import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.column.Column;

import java.util.List;

public class ColumnExample {

    public static void main(String[] args) {
        Column document = Column.of("name", "value");
        Value value = document.getValue();
        String name = document.getName();
        Column document1 = Column.of("name", Value.of(10));

        Column subDocument = Column.of("subColumn", document);

        Column age = Column.of("age", 29);
        String ageString = age.get(String.class);
        List<Integer> ages = age.get(new TypeReference<List<Integer>>() {});
        Object ageObject = age.get();


    }

    private ColumnExample() {}
}
