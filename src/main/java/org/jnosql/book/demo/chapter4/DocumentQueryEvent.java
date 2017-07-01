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
