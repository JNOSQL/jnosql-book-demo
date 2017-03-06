package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

@Entity
public class Dog extends Animal {

    @Column
    private String name;


}
