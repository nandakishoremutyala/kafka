package org.apache.kafka.clients.producer;

public class ProducerRecordBuilder<K, V> {

    private String topic;
    private Integer partition;
    private K key;
    private V value;
    private Long timestamp;

    public ProducerRecordBuilder(){};

    public ProducerRecordBuilder withKey(K key){
        this.key = key;
        return this;
    }

    public ProducerRecordBuilder withValue(V value){
        this.value = value;
        return this;
    }

    public ProducerRecordBuilder withTimestamp(Long timestamp){
        this.timestamp = timestamp;
        return this;
    }

    public ProducerRecordBuilder withTopic(String topic){
        this.topic = topic;
        return this;
    }

    public ProducerRecordBuilder withForcedPartition(Integer partition){
        this.partition = partition;
        return this;
    }

    public ProducerRecord build(){
        return new ProducerRecord<>(topic, partition, timestamp, key, value);
    }
}
