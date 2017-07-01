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
import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ColumnEntityApp {


    public static void main(String[] args) {

        ColumnEntity entity = ColumnEntity.of("columnFamily");
        String name = entity.getName();
        entity.add(Column.of("id", Value.of(10L)));
        entity.add(Column.of("version", 0.001));
        entity.add(Column.of("name", "Diana"));
        entity.add(Column.of("options", Arrays.asList(1, 2, 3)));

        List<Column> columns = entity.getColumns();
        Optional<Column> id = entity.find("id");
        entity.remove("options");
    }
}
