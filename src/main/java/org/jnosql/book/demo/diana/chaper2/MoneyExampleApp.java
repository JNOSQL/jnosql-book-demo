package org.jnosql.book.demo.diana.chaper2;


import java.util.List;
import java.util.Set;
import org.jnosql.diana.api.Value;

public class MoneyExampleApp {

    public static void main(String[] args) {
        Value value = Value.of("BRL 10.0");
        Money money = value.get(Money.class);
        List<Money> list = value.getList(Money.class);
        Set<Money> set = value.getSet(Money.class);
    }
}
