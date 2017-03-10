package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.EntityPostPersit;
import org.jnosql.artemis.EntityPrePersist;
import org.jnosql.artemis.column.ColumnEntityPostPersist;
import org.jnosql.artemis.column.ColumnEntityPrePersist;
import org.jnosql.artemis.column.EntityColumnPostPersist;
import org.jnosql.artemis.column.EntityColumnPrePersist;
import org.jnosql.artemis.document.DocumentEntityPostPersist;
import org.jnosql.artemis.document.DocumentEntityPrePersist;
import org.jnosql.artemis.document.EntityDocumentPostPersist;
import org.jnosql.artemis.document.EntityDocumentPrePersist;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class PersonColumnEvent {

    private static final Logger LOGGER = Logger.getLogger(PersonColumnEvent.class.getName());

    public void observer(@Observes EntityPrePersist event) {
        LOGGER.info("Event to pre persistence" + event.getValue());
    }

    public void observer(@Observes EntityColumnPrePersist event) {
        LOGGER.info("Event to pre document persistence" + event.getValue());
    }

    public void observer(@Observes ColumnEntityPrePersist event) {
        LOGGER.info("Event to pre document entity" + event.getEntity());
    }

    public void observer(@Observes ColumnEntityPostPersist event) {
        LOGGER.info("Event to post document entity" + event.getEntity());
    }

    public void observer(@Observes EntityPostPersit event) {
        LOGGER.info("Event to post persistence" + event.getValue());
    }

    public void observer(@Observes EntityColumnPostPersist event) {
        LOGGER.info("Event to post document entity" + event.getValue());
    }


}
