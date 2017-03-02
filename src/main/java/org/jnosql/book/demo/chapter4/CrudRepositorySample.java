package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.CrudRepository;
import org.jnosql.artemis.CrudRepositoryAsync;
import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;

import javax.inject.Inject;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by otaviojava on 2/28/17.
 */
public class CrudRepositorySample {


    public static void main(String[] args) {
        PersonRepository repository = null;

        PersonRepositoryAsync repositoryAsync = null;

        Person person = new Person();
        person.setNickname("diana");
        person.setName("Diana Goodness");

        List<Person> people = Collections.singletonList(person);

        repository.save(person);
        repository.save(people);
        repository.save(people, Duration.ofHours(2));
        repository.update(person);
        repository.update(people);
        repository.update(people);


        Stream<Person> dianas = repository.findByName("Diana");


        repositoryAsync.save(person);
        repositoryAsync.save(people);
        repositoryAsync.save(person, p -> {
        });
        repositoryAsync.save(people, Duration.ofHours(2));
        repositoryAsync.update(person);
        repositoryAsync.update(person, p -> {
        });
        repositoryAsync.update(people);
        repositoryAsync.update(people);


    }


    @Inject
    @Database(DatabaseType.DOCUMENT)
    private PersonRepository documentRepository;

    @Inject
    @Database(DatabaseType.COLUMN)
    private PersonRepository columnRepository;


    @Inject
    @Database(DatabaseType.DOCUMENT)
    private PersonRepositoryAsync documentRepositoryAsync;

    @Inject
    @Database(DatabaseType.COLUMN)
    private PersonRepositoryAsync columnRepositoryAsync;

    interface PersonRepository extends CrudRepository<Person> {

        List<Person> findByAddress(String address);

        Stream<Person> findByName(String name);

        Stream<Person> findByNameOrderByNameAsc(String name);

        Optional<Person> findByNickname(String nickname);

        void deleteByNickName(String nickname);
    }

    interface PersonRepositoryAsync extends CrudRepositoryAsync<Person> {
        void findByNickname(String nickname, Consumer<List<Person>> callback);

        void deleteByNickName(String nickname);

        void deleteByNickName(String nickname, Consumer<Void> callback);
    }
}
