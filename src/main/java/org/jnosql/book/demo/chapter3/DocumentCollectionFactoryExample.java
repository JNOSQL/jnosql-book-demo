package org.jnosql.book.demo.chapter3;


import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsyncFactory;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;

public class DocumentCollectionFactoryExample {

    public static void main(String[] args) {
        DocumentCollectionManagerFactory factory = null;
        DocumentCollectionManagerAsyncFactory asyncFactory = null;

        DocumentCollectionManager manager = factory.get("database");
        DocumentCollectionManagerAsync managerAsync = asyncFactory.getAsync("database");


    }
}
