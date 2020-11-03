package cslab.publisher.controller;
import cslab.publisher.config.MessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/publish")
public class PublisherController {

    // @Autowired
//    private RabbitTemplate template = new RabbitTemplate();

    // @Autowired
    private FanoutExchange fanout = new FanoutExchange(MessageConfig.EXCHANGE);

    @PostMapping(path = "/message/{message}")
    public @ResponseBody String message(@PathVariable String message){
        RabbitTemplate template = new RabbitTemplate();
        template.convertAndSend(fanout.getName() , "", message);
        return "Success!!";
    }
}
