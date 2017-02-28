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
