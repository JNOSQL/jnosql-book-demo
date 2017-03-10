package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.document.DocumentDeleteQueryExecute;
import org.jnosql.artemis.document.DocumentQueryExecute;
import org.jnosql.diana.api.document.DocumentDeleteQuery;
import org.jnosql.diana.api.document.DocumentQuery;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class DocumentQueryEvent {

    private static final Logger LOGGER = Logger.getLogger(DocumentQueryEvent.class.getName());

    public void observer(@Observes DocumentQueryExecute event) {
        DocumentQuery query = event.getQuery();
        LOGGER.info("Event to pre persistence" + query);
    }

    public void observer(@Observes DocumentDeleteQueryExecute event) {
        DocumentDeleteQuery query = event.getQuery();
        LOGGER.info("Event to pre persistence" + query);
    }
}
