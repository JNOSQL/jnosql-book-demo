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


import org.jnosql.diana.api.document.DocumentCollectionManagerAsyncFactory;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.api.document.DocumentConfigurationAsync;
import org.jnosql.diana.api.document.UnaryDocumentConfiguration;

public class DocumentConfigurationSample {

    public static void main(String[] args) {
        DocumentConfiguration configuration = null;
        DocumentConfigurationAsync configurationAsync = null;

        DocumentCollectionManagerFactory managerFactory = configuration.get();
        DocumentCollectionManagerAsyncFactory managerAsyncFactory = configurationAsync.getAsync();

        UnaryDocumentConfiguration unaryDocumentConfiguration = null;

        DocumentCollectionManagerFactory managerFactory1 = unaryDocumentConfiguration.get();
        DocumentCollectionManagerAsyncFactory managerAsyncFactory1 = unaryDocumentConfiguration.getAsync();

    }
}
