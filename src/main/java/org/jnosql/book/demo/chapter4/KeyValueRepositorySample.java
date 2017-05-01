package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.key.KeyValueTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class KeyValueRepositorySample {

    public static void main(String[] args) {

        KeyValueTemplate template = null;
        User user = new User();
        user.setNickname("ada");
        user.setAge(10);
        user.setName("Ada Lovelace");
        List<User> users = Collections.singletonList(user);

        template.put(user);
        template.put(users);

        Optional<Person> ada = template.get("ada", Person.class);
        Iterable<Person> usersFound = template.get(Collections.singletonList("ada"), Person.class);

    }
}
