package org.jnosql.book.demo.diana.chapter3;


import org.jnosql.diana.api.key.BucketManagerFactory;
import org.jnosql.diana.api.key.KeyValueConfiguration;

public class KeyValueConfigurationSample {

    public static void main(String[] args) {
        KeyValueConfiguration configuration = null;
        BucketManagerFactory managerFactory = configuration.get();
    }
}
