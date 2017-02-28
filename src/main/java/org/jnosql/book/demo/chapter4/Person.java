package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

import java.util.List;

@Entity
public class Person {
    @Column
    private String nickname;
    @Column
    private String name;
    @Column
    private List<String> phones;
    //ignored
    private String address;

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public String getAddress() {
        return address;
    }
}
