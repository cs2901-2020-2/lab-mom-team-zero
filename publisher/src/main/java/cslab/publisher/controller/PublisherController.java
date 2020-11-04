package cslab.publisher.controller;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(path = "/publish")
public class PublisherController {

    private static final String EXCHANGE_NAME = "logs";

    @PostMapping(path = "/message/{message}")
    public @ResponseBody String message(@PathVariable String message) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection conn = factory.newConnection();
             Channel channel = conn.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        }
        return "Success!!";
    }
}
