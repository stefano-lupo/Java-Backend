package tech.stefanolupo.westburyclub.service;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import tech.stefanolupo.westburyclub.service.config.WestburyClubServiceModule;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class WestburyClubService extends Application<WestburyClubServiceConfiguration> {

    private GuiceBundle<WestburyClubServiceConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new WestburyClubService().run(args);
    }

    @Override
    public void initialize(Bootstrap<WestburyClubServiceConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<WestburyClubServiceConfiguration>newBuilder()
                .addModule(new WestburyClubServiceModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(WestburyClubServiceConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public String getName() {
        return "westbury-club-service";
    }

    @Override
    public void run(WestburyClubServiceConfiguration configuration, Environment environment) throws Exception {
        // Auto config handles resources
        // health checks must not inherit from InjectableHealthCheck
        // Enable CORS headers

        //TODO
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
