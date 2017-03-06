package org.jnosql.book.demo.chapter4;


import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final String currency;

    private final BigDecimal value;

    public Money(String currency, BigDecimal value) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(currency, money.currency) &&
                Objects.equals(value.doubleValue(), money.value.doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value.doubleValue());
    }

    @Override
    public String toString() {
        return currency + " " + value.toString();
    }

    public static Money parse(String dbData) {
        String[] values = dbData.split(" ");
        String currency = values[0];
        BigDecimal value = BigDecimal.valueOf(Double.valueOf(values[1]));
        return new Money(currency, value);
    }
}
