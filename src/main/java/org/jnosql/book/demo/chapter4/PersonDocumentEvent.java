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
import org.jnosql.artemis.document.DocumentEntityPostPersist;
import org.jnosql.artemis.document.DocumentEntityPrePersist;
import org.jnosql.artemis.document.EntityDocumentPostPersist;
import org.jnosql.artemis.document.EntityDocumentPrePersist;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class PersonDocumentEvent {

    private static final Logger LOGGER = Logger.getLogger(PersonDocumentEvent.class.getName());

    public void observer(@Observes EntityPrePersist event) {
        LOGGER.info("Event to pre persistence" + event.getValue());
    }

    public void observer(@Observes EntityDocumentPrePersist event) {
        LOGGER.info("Event to pre document persistence" + event.getValue());
    }

    public void observer(@Observes DocumentEntityPrePersist event) {
        LOGGER.info("Event to pre document entity" + event.getEntity());
    }

    public void observer(@Observes DocumentEntityPostPersist event) {
        LOGGER.info("Event to post document entity" + event.getEntity());
    }

    public void observer(@Observes EntityPostPersit event) {
        LOGGER.info("Event to post persistence" + event.getValue());
    }

    public void observer(@Observes EntityDocumentPostPersist event) {
        LOGGER.info("Event to post document entity" + event.getValue());
    }


}
