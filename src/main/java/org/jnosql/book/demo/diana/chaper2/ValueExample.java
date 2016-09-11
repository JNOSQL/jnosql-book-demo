package org.jnosql.book.demo.diana.chaper2;


import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.jnosql.diana.api.Value;

public class ValueExample {


    public static void main(String[] args) {
        Value value = Value.of(12);
        String string = value.get(String.class);
        List<Integer> list = value.getList(Integer.class);
        Set<Long> set = value.getSet(Long.class);
        Stream<Integer> stream = value.getStream(Integer.class);
        Integer integer = value.cast();
    }
}
