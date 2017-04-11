package org.apache.kafka.clients.producer;

import org.apache.kafka.common.utils.Time;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ProducerRecordBuilderTest {

    @Test
    public void testEqualsAndHashCode() {

        Long now = System.currentTimeMillis();

        ProducerRecord<String, Integer> producerRecord =
                new ProducerRecord<>("test", 1, now, "key", 1);

        ProducerRecord<String, Integer> builderRecord =
                new ProducerRecordBuilder<String, Integer>()
                        .withTopic("test")
                        .withKey("key")
                        .withValue(1)
                        .withTimestamp(now)
                        .withForcedPartition(1)
                        .build();

        assertEquals(producerRecord, builderRecord);
        assertEquals(producerRecord.hashCode(), builderRecord.hashCode());

    }
}
