package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.column.ColumnDeleteQueryExecute;
import org.jnosql.artemis.column.ColumnQueryExecute;
import org.jnosql.artemis.document.DocumentDeleteQueryExecute;
import org.jnosql.artemis.document.DocumentQueryExecute;
import org.jnosql.diana.api.column.ColumnDeleteQuery;
import org.jnosql.diana.api.column.ColumnQuery;
import org.jnosql.diana.api.document.DocumentDeleteQuery;
import org.jnosql.diana.api.document.DocumentQuery;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class ColumnQueryEvent {

    private static final Logger LOGGER = Logger.getLogger(ColumnQueryEvent.class.getName());

    public void observer(@Observes ColumnQueryExecute event) {
        ColumnQuery query = event.getQuery();
        LOGGER.info("Event to pre persistence" + query);
    }

    public void observer(@Observes ColumnDeleteQueryExecute event) {
        ColumnDeleteQuery query = event.getQuery();
        LOGGER.info("Event to pre persistence" + query);
    }
}
