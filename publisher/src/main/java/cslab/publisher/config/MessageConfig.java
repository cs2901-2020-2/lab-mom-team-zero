package cslab.publisher.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MessageConfig {

public static final String QUEUE = "queue";
public static final String EXCHANGE = "fanout";
//public static final String ROUTINGKEY = "routingKey";

    public MessageConfig sender() {
        return new MessageConfig();
    }

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
        //return new AnonymousQueue();
    }


    public Queue queue2(){
        //return new Queue(QUEUE);
        return new AnonymousQueue();
    }
/*
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }
*/

    @Bean
    public Binding binding(FanoutExchange fanout, Queue queue1){
        return BindingBuilder.bind(queue1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout, Queue queue2){
        return BindingBuilder.bind(queue2).to(fanout);
    }

    /*

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
*/
   /* @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    */
}

