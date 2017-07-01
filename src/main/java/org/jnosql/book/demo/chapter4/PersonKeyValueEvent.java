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


import org.jnosql.artemis.EntityPostPersit;
import org.jnosql.artemis.EntityPrePersist;
import org.jnosql.artemis.column.ColumnEntityPostPersist;
import org.jnosql.artemis.column.ColumnEntityPrePersist;
import org.jnosql.artemis.column.EntityColumnPostPersist;
import org.jnosql.artemis.column.EntityColumnPrePersist;
import org.jnosql.artemis.key.EntityKeyValuePostPersist;
import org.jnosql.artemis.key.EntityKeyValuePrePersist;
import org.jnosql.artemis.key.KeyValueEntityPostPersist;
import org.jnosql.artemis.key.KeyValueEntityPrePersist;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class PersonKeyValueEvent {

    private static final Logger LOGGER = Logger.getLogger(PersonKeyValueEvent.class.getName());

    public void observer(@Observes EntityPrePersist event) {
        LOGGER.info("Event to pre persistence" + event.getValue());
    }

    public void observer(@Observes EntityKeyValuePrePersist event) {
        LOGGER.info("Event to pre document persistence" + event.getValue());
    }

    public void observer(@Observes KeyValueEntityPrePersist event) {
        LOGGER.info("Event to pre document entity" + event.getEntity());
    }

    public void observer(@Observes KeyValueEntityPostPersist event) {
        LOGGER.info("Event to post document entity" + event.getEntity());
    }

    public void observer(@Observes EntityPostPersit event) {
        LOGGER.info("Event to post persistence" + event.getValue());
    }

    public void observer(@Observes EntityKeyValuePostPersist event) {
        LOGGER.info("Event to post document entity" + event.getValue());
    }


}
