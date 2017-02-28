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
