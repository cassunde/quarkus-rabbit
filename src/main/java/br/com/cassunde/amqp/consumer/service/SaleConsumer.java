package br.com.cassunde.amqp.consumer.service;

import br.com.cassunde.amqp.consumer.model.Persona;
import br.com.cassunde.amqp.consumer.model.Sale;
import io.quarkus.rabbit.client.RabbitListenerConfiguration;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

@Dependent
public class SaleConsumer {

    public void listen(@Observes @RabbitListenerConfiguration(queue = "vendor", type = Persona.class) Persona persona){
        System.out.println("Message read from persona : " + persona);
    }

    public void listenOther(@Observes @RabbitListenerConfiguration(queue = "sales", type = Sale.class) Sale sale){
        System.out.println("Message read from Sales : " + sale);
    }
}
