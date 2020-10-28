package cslab.publisher.controller;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/publish")
public class PublisherController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    @PostMapping(path = "/message/{message}")
    public @ResponseBody String message(@PathVariable String message){
        template.convertAndSend(fanout.getName() , "", message);
        return "Success!!";
    }
}
