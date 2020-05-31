package com.example.rabbitdemo.message;

import com.example.rabbitdemo.model.RabbitMessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(RabbitDemoSink.class)
public class RabbitMessageReader {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMessageReader.class);

    @StreamListener("rabbitDemoSink")
    public void processMessage(RabbitMessageModel m){
        logger.info("user= {}. msg={}",m.getUserName(), m.getMessage());
    }
}
