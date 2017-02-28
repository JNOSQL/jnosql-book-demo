package org.jnosql.book.demo.chapter4;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Key;

import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
public class User {

    @Key
    private String nickname;

    private String name;

    private int age;

    public User(String nickname, String name, int age) {
        this.nickname = nickname;
        this.name = name;
        this.age = age;
    }

    User() {}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("nickname", nickname)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
