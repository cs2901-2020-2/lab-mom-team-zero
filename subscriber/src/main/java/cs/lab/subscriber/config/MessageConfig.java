package cs.lab.subscriber.config;
import cs.lab.subscriber.controller.SubscriberController;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MessageConfig {

    public static final String QUEUE = "queue";
    public static final String EXCHANGE = "fanout";

    public MessageConfig sender() {
        return new MessageConfig();
    }

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Queue queue1(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(FanoutExchange fanout, Queue queue1){
        return BindingBuilder.bind(queue1).to(fanout);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(SubscriberController receiver) {
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

