package com.example.rabbitdemo.controller;

import com.example.rabbitdemo.message.RabbitDemoSource;
import com.example.rabbitdemo.model.RabbitMessageModel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@EnableBinding(RabbitDemoSource.class)
public class DemoController {

    private final RabbitDemoSource rabbitDemoSource;

    public DemoController(RabbitDemoSource rabbitDemoSource){
        this.rabbitDemoSource = rabbitDemoSource;
    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        RabbitMessageModel model = new RabbitMessageModel();
        model.setUserName("demoUser");
        model.setMessage("hello");

        rabbitDemoSource.sendMessage().send(MessageBuilder.withPayload(model).build());
        return "!";
    }
}
