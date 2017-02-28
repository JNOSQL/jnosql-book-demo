package org.jnosql.book.demo.chaper2;


import org.jnosql.diana.api.ValueWriter;

public class MoneyValueWriter implements ValueWriter<Money, String> {

    @Override
    public boolean isCompatible(Class clazz) {
        return Money.class.equals(clazz);
    }

    @Override
    public String write(Money object) {
        return object.toString();
    }
}
