package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.column.Column;
import org.jnosql.diana.api.column.ColumnEntity;
import org.jnosql.diana.api.column.ColumnFamilyManager;
import org.jnosql.diana.api.column.ColumnFamilyManagerAsync;
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentEntity;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ColumnManagerExample {

    public static void main(String[] args) {
        ColumnEntity entity = ColumnEntity.of("columnFamily");
        Column diana = Column.of("name", "Diana");
        entity.add(diana);

        List<ColumnEntity> entities = Collections.singletonList(entity);
        ColumnFamilyManager manager = null;

        ColumnFamilyManagerAsync managerAsync = null;

        //saves operations
        manager.save(entity);
        manager.save(entity, Duration.ofHours(2L));//saves with 2 hours of TTL
        manager.save(entities, Duration.ofHours(2L));//saves with 2 hours of TTL
        //updates operations
        manager.update(entity);
        manager.update(entities);


        //saves operations
        managerAsync.save(entity);
        managerAsync.save(entity, Duration.ofHours(2L));//saves with 2 hours of TTL
        managerAsync.save(entities, Duration.ofHours(2L));//saves with 2 hours of TTL
        //updates operations
        managerAsync.update(entity);
        managerAsync.update(entities);

        //callback
        Consumer<ColumnEntity> callBack = e -> {
        };
        managerAsync.save(entity, callBack);
        managerAsync.update(entity, callBack);

    }
}
