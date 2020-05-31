package com.example.rabbitdemo.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitDemoSink {

    @Input("rabbitDemoSink")
    SubscribableChannel input();

}
