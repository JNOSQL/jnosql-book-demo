package org.jnosql.book.demo.chapter3;


import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnCondition;
import org.jnosql.diana.api.column.ColumnDeleteQuery;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsync;

public class ColumnQueryDeleteExample {

    public static void main(String[] args) {


        ColumnFamilyManager manager = null;
        ColumnFamilyManagerAsync managerAsync = null;

        ColumnDeleteQuery query = ColumnDeleteQuery.of("collection");
        ColumnCondition ageBiggerTen = ColumnCondition.gt(Column.of("age", 10));
        query.and(ageBiggerTen);


        manager.delete(query);

        managerAsync.delete(query);
        managerAsync.delete(query, v -> {});
    }
}
