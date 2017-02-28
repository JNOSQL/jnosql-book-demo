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
}
