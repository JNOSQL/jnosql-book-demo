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
import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnCondition;
import org.jnosql.diana.api.column.ColumnEntity;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsync;
import org.jnosql.diana.api.column.ColumnQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ColumnQueryExample {

    public static void main(String[] args) {
        ColumnCondition nameEqualsAda = ColumnCondition.eq(Column.of("name", "Ada"));
        ColumnCondition youngerThan2Years = ColumnCondition.lt(Column.of("age", 2));
        ColumnCondition condition = nameEqualsAda.and(youngerThan2Years);
        ColumnCondition nameNotEqualsAda = nameEqualsAda.negate();

        ColumnFamilyManager manager = null;
        ColumnFamilyManagerAsync managerAsync = null;

        ColumnQuery query = ColumnQuery.of("collection");
        ColumnCondition ageBiggerTen = ColumnCondition.gt(Column.of("age", 10));
        query.and(ageBiggerTen);
        query.addSort(Sort.of("name", Sort.SortType.ASC));

        query.withMaxResults(10);
        query.withFirstResult(2);

        List<ColumnEntity> entities = manager.select(query);
        Optional<ColumnEntity> entity = manager.singleResult(query);

        Consumer<List<ColumnEntity>> callback = e -> {};
        managerAsync.select(query, callback);
    }

    private ColumnQueryExample() {}
}
