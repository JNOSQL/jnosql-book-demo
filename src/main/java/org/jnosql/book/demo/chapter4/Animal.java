package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.MappedSuperclass;

@MappedSuperclass
public class Animal {

    @Column
    private String race;

    @Column
    private Integer age;


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
