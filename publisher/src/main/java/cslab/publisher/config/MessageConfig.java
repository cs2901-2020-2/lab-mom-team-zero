package cslab.publisher.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@Configuration
public class MessageConfig {

//public static final String QUEUE = "queue";
//public static final String EXCHANGE = "fanout";
//    // @Bean
//    // public FanoutExchange fanout(){
//    //     return new FanoutExchange(EXCHANGE);
//    // }
//
//    // @Bean
//    // public RabbitTemplate template() {return new RabbitTemplate();}
//
//    @Bean
//    public Queue queue(){
//        return new Queue(QUEUE);
//    }
//    @Bean
//    public Binding binding(FanoutExchange fanout, Queue queue){
//        return BindingBuilder.bind(queue).to(fanout);
//    }

}

