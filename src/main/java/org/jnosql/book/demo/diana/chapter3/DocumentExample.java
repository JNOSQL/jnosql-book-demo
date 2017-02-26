package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.TypeReference;
import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.document.Document;

import java.util.List;

public class DocumentExample {

    public static void main(String[] args) {
        Document document = Document.of("name", "value");
        Value value = document.getValue();
        String name = document.getName();
        Document document1 = Document.of("name", Value.of(10));

        Document subDocument = Document.of("subDocument", document);

        Document age = Document.of("age", 29);
        String ageString = age.get(String.class);
        List<Integer> ages = age.get(new TypeReference<List<Integer>>() {});
        Object ageObject = age.get();


    }
}
