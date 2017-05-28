package ro.unicredit.ticketingservice.configurations;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import ro.unicredit.ticketingservice.presentationLayer.controllers.EventController;
import ro.unicredit.ticketingservice.presentationLayer.controllers.TicketController;

/**
 * Created by donic on 5/27/2017.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(TicketController.class);
        register(EventController.class);
    }
}
