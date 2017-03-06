package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.Column;
import org.jnosql.artemis.Embeddable;

@Embeddable
public class Author {

    @Column
    private String name;
    @Column
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
