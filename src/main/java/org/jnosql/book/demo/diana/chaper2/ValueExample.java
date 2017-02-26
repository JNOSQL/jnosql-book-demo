package org.jnosql.book.demo.diana.chaper2;


import org.jnosql.diana.api.TypeReference;
import org.jnosql.diana.api.Value;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ValueExample {


    public static void main(String[] args) {
        Value value = Value.of(12);
        String string = value.get(String.class);
        List<Integer> list = value.get(new TypeReference<List<Integer>>() {});
        Set<Long> set = value.get(new TypeReference<Set<Long>>() {});
        Stream<Integer> stream = value.get(new TypeReference<Stream<Integer>>() {});
        Object integer = value.get();
    }
}
