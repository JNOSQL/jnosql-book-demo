package org.jnosql.book.demo.chaper2;


import org.jnosql.diana.api.Value;
import org.jnosql.diana.api.key.KeyValueEntity;

public class KeyValueEntityApp {

    public static void main(String[] args) {
        KeyValueEntity<String> entity = KeyValueEntity.of("key", Value.of(123));
        KeyValueEntity<Integer> entity2 = KeyValueEntity.of(12, "Text");
    }
}
