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


import org.jnosql.artemis.document.DocumentTemplate;
import org.jnosql.artemis.document.DocumentTemplateAsync;
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentDeleteQuery;
import org.jnosql.diana.api.document.DocumentQuery;
import org.jnosql.diana.api.document.query.DocumentQueryBuilder;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.delete;
import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;

public class DocumentRepositorySample {

    public static void main(String[] args) {
        DocumentTemplate template = null;



        Person person = new Person();
        person.setAddress("Olympus");
        person.setName("Artemis Good");
        person.setPhones(Arrays.asList("55 11 94320121", "55 11 94320121"));
        person.setNickname("artemis");

        List<Person> people = Collections.singletonList(person);

        Person personUpdated = template.insert(person);
        template.insert(people);
        template.insert(person, Duration.ofHours(1L));

        template.update(person);
        template.update(people);


        DocumentQuery query = select().from("Person").where("address").eq("Olympus").build();


        List<Person> peopleWhoLiveOnOlympus = template.select(query);
        Optional<Person> artemis = template.singleResult(select().from("Person")
                .where("nickname").eq("artemis").build());


        DocumentDeleteQuery deleteQuery = delete().from("Person").where("address").eq("Olympus").build();
        template.delete(deleteQuery);


        DocumentTemplateAsync templateAsync = null;
        Consumer<Person> callback = p -> {};
        templateAsync.insert(person);
        templateAsync.insert(person, Duration.ofHours(1L));
        templateAsync.insert(person, callback);
        templateAsync.insert(people);

        templateAsync.update(person);
        templateAsync.update(person, callback);
        templateAsync.update(people);

        Consumer<List<Person>> callBackPeople = p -> {};
        Consumer<Void> voidCallBack = v ->{};
        templateAsync.select(query, callBackPeople);
        templateAsync.delete(deleteQuery);
        templateAsync.delete(deleteQuery, voidCallBack);

    }

    private DocumentRepositorySample() {}

}
