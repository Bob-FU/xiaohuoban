package com.example.rabbitdemo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RabbitDemoSource {

    @Output("demoSendChannel")
    MessageChannel sendMessage();

}
