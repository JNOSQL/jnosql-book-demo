package org.jnosql.book.demo.diana.chaper2;

import java.math.BigDecimal;

public class Money {

    private final String currency;

    private final BigDecimal value;

    Money(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return currency + ' ' + value;
    }

    public static Money parse(String text) {
        String[] texts = text.split(" ");
        return new Money(texts[0], BigDecimal.valueOf(Double.valueOf(texts[1])));
    }
}
