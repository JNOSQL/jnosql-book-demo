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
