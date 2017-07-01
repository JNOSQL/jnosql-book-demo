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

package org.jnosql.book.demo.chapter3;


import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsync;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsyncFactory;
import org.jnosql.diana.api.column.ColumnFamilyManagerFactory;

public class ColumnFamilyFactoryExample {

    public static void main(String[] args) {
        ColumnFamilyManagerFactory factory = null;
        ColumnFamilyManagerAsyncFactory asyncFactory = null;

        ColumnFamilyManager manager = factory.get("database");
        ColumnFamilyManagerAsync managerAsync = asyncFactory.getAsync("database");


    }
}
