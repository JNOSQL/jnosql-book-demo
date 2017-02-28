package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.key.KeyValueRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class KeyValueRepositorySample {

    public static void main(String[] args) {
        KeyValueRepository repository = null;
        User user = new User();
        user.setNickname("ada");
        user.setAge(10);
        user.setName("Ada Lovelace");
        List<User> users = Collections.singletonList(user);

        repository.put(user);
        repository.put(users);

        Optional<Person> ada = repository.get("ada", Person.class);
        Iterable<Person> usersFound = repository.get(Collections.singletonList("ada"), Person.class);

    }
}
