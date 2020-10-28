package cs.lab.subscriber.controller;


import cs.lab.subscriber.config.MessageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping(path = "/consum")
public class SubscriberController {

    String in;
    private static final Logger log = LoggerFactory.getLogger(SubscriberController.class);

    @RabbitListener(queues = MessageConfig.QUEUE)

    public String consumer(String in){
        this.in = in;
        log.info("message received " +  in);
        return "success!! " + in;
    }

    @GetMapping(path = "/consum")
    public @ResponseBody String showData(){
        return in;
    }

}
