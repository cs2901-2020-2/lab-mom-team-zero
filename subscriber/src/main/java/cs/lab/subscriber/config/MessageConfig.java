package cs.lab.subscriber.config;
import org.springframework.amqp.core.*;
import cs.lab.subscriber.Receiver;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//import javax.sound.midi.Receiver;


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
        //return new Queue(QUEUE);
        return new AnonymousQueue();
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

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}

