/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package org.jnosql.book.demo.chapter4;

import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;
import org.jnosql.artemis.Repository;
import org.jnosql.artemis.RepositoryAsync;

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

    interface PersonRepository extends Repository<Person> {

        List<Person> findByAddress(String address);

        Stream<Person> findByName(String name);

        Stream<Person> findByNameOrderByNameAsc(String name);

        Optional<Person> findByNickname(String nickname);

        void deleteByNickName(String nickname);
    }

    interface PersonRepositoryAsync extends RepositoryAsync<Person> {
        void findByNickname(String nickname, Consumer<List<Person>> callback);

        void deleteByNickName(String nickname);

        void deleteByNickName(String nickname, Consumer<Void> callback);
    }
}
