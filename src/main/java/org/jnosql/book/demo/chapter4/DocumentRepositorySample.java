package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.document.DocumentRepository;
import org.jnosql.artemis.document.DocumentRepositoryAsync;
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentDeleteQuery;
import org.jnosql.diana.api.document.DocumentQuery;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DocumentRepositorySample {

    public static void main(String[] args) {
        DocumentRepository repository = null;



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

        DocumentQuery query = DocumentQuery.of("Person");
        query.and(DocumentCondition.eq(Document.of("address", "Olympus")));

        List<Person> peopleWhoLiveOnOlympus = repository.find(query);
        Optional<Person> artemis = repository.singleResult(DocumentQuery.of("Person")
                .and(DocumentCondition.eq(Document.of("nickname", "artemis"))));

        DocumentDeleteQuery deleteQuery = query.toDeleteQuery();
        repository.delete(deleteQuery);


        DocumentRepositoryAsync repositoryAsync = null;
        Consumer<Person> callback = p -> {};
        repositoryAsync.save(person);
        repositoryAsync.save(person, Duration.ofHours(1L));
        repositoryAsync.save(person, callback);
        repositoryAsync.save(people);

        repositoryAsync.update(person);
        repositoryAsync.update(person, callback);
        repositoryAsync.update(people);

    }

}
