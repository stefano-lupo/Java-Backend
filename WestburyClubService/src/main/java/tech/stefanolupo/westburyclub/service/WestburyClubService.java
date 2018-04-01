package tech.stefanolupo.westburyclub.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WestburyClubService extends Application<WestburyClubServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new WestburyClubService().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<WestburyClubServiceConfiguration> bootstrap) {

    }

    @Override
    public void run(WestburyClubServiceConfiguration configuration, Environment environment) throws Exception {
//        final AccountResource resource = new AccountResource(configuration.getTemplate(), configuration.getDefaultName());
//        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
//
//        environment.jersey().register(resource);
//        environment.healthChecks().register("template", healthCheck);
    }
}
