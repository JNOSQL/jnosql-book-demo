package org.jnosql.book.demo.chapter3;


import org.jnosql.diana.api.Sort;
import org.jnosql.diana.api.document.Document;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerAsync;
import org.jnosql.diana.api.document.DocumentCondition;
import org.jnosql.diana.api.document.DocumentEntity;
import org.jnosql.diana.api.document.DocumentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DocumentQueryExample {

    public static void main(String[] args) {
        DocumentCondition nameEqualsAda = DocumentCondition.eq(Document.of("name", "Ada"));
        DocumentCondition youngerThan2Years = DocumentCondition.lt(Document.of("age", 2));
        DocumentCondition condition = nameEqualsAda.and(youngerThan2Years);
        DocumentCondition nameNotEqualsAda = nameEqualsAda.negate();

        DocumentCollectionManager manager = null;
        DocumentCollectionManagerAsync managerAsync = null;

        DocumentQuery query = DocumentQuery.of("collection");
        DocumentCondition ageBiggerTen = DocumentCondition.gt(Document.of("age", 10));
        query.and(ageBiggerTen);
        query.addSort(Sort.of("name", Sort.SortType.ASC));

        query.setLimit(10);
        query.setStart(2);

        List<DocumentEntity> entities = manager.find(query);
        Optional<DocumentEntity> entity = manager.singleResult(query);

        Consumer<List<DocumentEntity>> callback = e -> {};
        managerAsync.find(query, callback);
    }
}
