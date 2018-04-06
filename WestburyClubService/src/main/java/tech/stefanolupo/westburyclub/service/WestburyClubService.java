package tech.stefanolupo.westburyclub.service;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import tech.stefanolupo.westburyclub.service.config.WestburyClubServiceModule;

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
    }
}
