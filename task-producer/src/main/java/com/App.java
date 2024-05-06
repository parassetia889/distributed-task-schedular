package com;

import com.model.Task;
import com.service.TaskProducerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        String bootstrapServers = "localhost:9092";
        String topicName = "tasks";
        TaskProducerService taskProducerService = new TaskProducerService(bootstrapServers, topicName);

        Task task1 = new Task("Produce data file");
        taskProducerService.produceTask(task1);

        Task task2 = new Task("Generate Report");
        taskProducerService.produceTask(task2);    }
}
