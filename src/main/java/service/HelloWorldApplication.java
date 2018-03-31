package service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        String[] arr = {"Hello", "my" , "world"};
        Set<String> stringSet = Arrays.stream(arr).filter(x -> x.length() < 3).collect(Collectors.toSet());
        new HelloWorldApplication().run(args);
        Derp derp = Derp.builder().setInt(0).build();
        System.out.println(derp.getInt());
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.jersey().register(resource);
        environment.healthChecks().register("template", healthCheck);
    }
}
