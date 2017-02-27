package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.column.ColumnConfiguration;
import org.jnosql.diana.api.column.ColumnConfigurationAsync;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsyncFactory;
import org.jnosql.diana.api.column.ColumnFamilyManagerFactory;
import org.jnosql.diana.api.column.UnaryColumnConfiguration;

public class ColumnConfigurationSample {


    public static void main(String[] args) {
        ColumnConfiguration configuration = null;
        ColumnConfigurationAsync configurationAsync = null;

        ColumnFamilyManagerFactory managerFactory = configuration.get();
        ColumnFamilyManagerAsyncFactory managerAsyncFactory = configurationAsync.getAsync();

        UnaryColumnConfiguration unaryDocumentConfiguration = null;

        ColumnFamilyManagerFactory managerFactory1 = unaryDocumentConfiguration.get();
        ColumnFamilyManagerAsyncFactory managerAsyncFactory1 = unaryDocumentConfiguration.getAsync();

    }
}
