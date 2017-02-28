package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.column.ColumnRepository;
import org.jnosql.artemis.column.ColumnRepositoryAsync;
import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnCondition;
import org.jnosql.diana.api.column.ColumnDeleteQuery;
import org.jnosql.diana.api.column.ColumnQuery;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ColumnRepositorySample {

    public static void main(String[] args) {
        ColumnRepository repository = null;



        Person person = new Person();
        person.setAddress("Olympus");
        person.setName("Artemis Good");
        person.setPhones(Arrays.asList("55 11 94320121", "55 11 94320121"));
        person.setNickname("artemis");

        List<Person> people = Collections.singletonList(person);

        Person personUpdated = repository.save(person);
        repository.save(people);
        repository.save(person, Duration.ofHours(1L));

        repository.update(person);
        repository.update(people);

        ColumnQuery query = ColumnQuery.of("Person");
        query.and(ColumnCondition.eq(Column.of("address", "Olympus")));

        List<Person> peopleWhoLiveOnOlympus = repository.find(query);
        Optional<Person> artemis = repository.singleResult(ColumnQuery.of("Person")
                .and(ColumnCondition.eq(Column.of("nickname", "artemis"))));

        ColumnDeleteQuery deleteQuery = query.toDeleteQuery();
        repository.delete(deleteQuery);


        ColumnRepositoryAsync repositoryAsync = null;
        Consumer<Person> callback = p -> {};
        repositoryAsync.save(person);
        repositoryAsync.save(person, Duration.ofHours(1L));
        repositoryAsync.save(person, callback);
        repositoryAsync.save(people);

        repositoryAsync.update(person);
        repositoryAsync.update(person, callback);
        repositoryAsync.update(people);

        Consumer<List<Person>> callBackPeople = p -> {};
        Consumer<Void> voidCallBack = v ->{};
        repositoryAsync.find(query, callBackPeople);
        repositoryAsync.delete(deleteQuery);
        repositoryAsync.delete(deleteQuery, voidCallBack);

    }

}
