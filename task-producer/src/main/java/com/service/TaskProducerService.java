package com.service;

import com.model.Task;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TaskProducerService {

    private final KafkaProducer<String, Task> producer;
    private final String topicName;

    public TaskProducerService(String bootstrapServers, String topicName){
        this.topicName = topicName;

        Properties props = new Properties();

        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "com.example.taskproducer.serializer.TaskSerializer");
        // Add more producer properties as needed
        this.producer = new KafkaProducer<>(props);
    }

    public void produceTask(Task task) {
        ProducerRecord<String, Task> record = new ProducerRecord<>(topicName, task.getId(), task);
        producer.send(record);

    }
}
