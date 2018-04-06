package tech.stefanolupo.westburyclub.service.healthchecks;

import com.google.inject.Inject;
import com.hubspot.dropwizard.guice.InjectableHealthCheck;

public class TemplateHealthCheck extends InjectableHealthCheck {

    private String template;

    @Inject
    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    public String getName() {
        return "WestburyClubServiceHealthCheck";
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("Template does not include the name");
        }

        return Result.healthy();
    }
}
