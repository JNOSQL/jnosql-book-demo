package org.jnosql.book.demo.chapter4;


import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class KeyValueRepositoryValue {

    public static void main(String[] args) {
        UserRepository userRepository = null;
        User user = new User("ada", "Ada Lovelace", 30);
        List<User> users = Collections.singletonList(user);
        userRepository.put(user);
        userRepository.put(user, Duration.ofHours(1));
        userRepository.put(users);
        userRepository.put(users, Duration.ofHours(1));

        Optional<User> userOptional = userRepository.get("ada");
        Iterable<User> usersFound = userRepository.get(Collections.singletonList("ada"));

    }


}

