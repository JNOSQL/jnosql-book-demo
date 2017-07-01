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


import org.jnosql.artemis.column.ColumnDeleteQueryExecute;
import org.jnosql.artemis.column.ColumnQueryExecute;
import org.jnosql.diana.api.column.ColumnDeleteQuery;
import org.jnosql.diana.api.column.ColumnQuery;

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
