package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Convert;
import org.jnosql.artemis.Entity;

@Entity
public class Worker {

    @Column
    private String name;

    @Column
    private String localtion;

    @Column
    @Convert(MoneyConverter.class)
    private Money money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
