package org.jnosql.book.demo.diana.chapter3;


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

        query.setLimit(10);
        query.setStart(2);

        List<ColumnEntity> entities = manager.find(query);
        Optional<ColumnEntity> entity = manager.singleResult(query);

        Consumer<List<ColumnEntity>> callback = e -> {};
        managerAsync.find(query, callback);
    }
}
