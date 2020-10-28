package cs.lab.subscriber.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SubscriberController {

    private static final Logger log = LoggerFactory.getLogger(SubscriberController.class);

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
    }
}



