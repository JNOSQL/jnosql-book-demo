package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.document.DocumentTemplate;
import org.jnosql.artemis.document.DocumentTemplateAsync;
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
        DocumentTemplate template = null;



        Person person = new Person();
        person.setAddress("Olympus");
        person.setName("Artemis Good");
        person.setPhones(Arrays.asList("55 11 94320121", "55 11 94320121"));
        person.setNickname("artemis");

        List<Person> people = Collections.singletonList(person);

        Person personUpdated = template.save(person);
        template.save(people);
        template.save(person, Duration.ofHours(1L));

        template.update(person);
        template.update(people);

        DocumentQuery query = DocumentQuery.of("Person");
        query.and(DocumentCondition.eq(Document.of("address", "Olympus")));

        List<Person> peopleWhoLiveOnOlympus = template.find(query);
        Optional<Person> artemis = template.singleResult(DocumentQuery.of("Person")
                .and(DocumentCondition.eq(Document.of("nickname", "artemis"))));

        DocumentDeleteQuery deleteQuery = query.toDeleteQuery();
        template.delete(deleteQuery);


        DocumentTemplateAsync templateAsync = null;
        Consumer<Person> callback = p -> {};
        templateAsync.save(person);
        templateAsync.save(person, Duration.ofHours(1L));
        templateAsync.save(person, callback);
        templateAsync.save(people);

        templateAsync.update(person);
        templateAsync.update(person, callback);
        templateAsync.update(people);

        Consumer<List<Person>> callBackPeople = p -> {};
        Consumer<Void> voidCallBack = v ->{};
        templateAsync.find(query, callBackPeople);
        templateAsync.delete(deleteQuery);
        templateAsync.delete(deleteQuery, voidCallBack);

    }

}
