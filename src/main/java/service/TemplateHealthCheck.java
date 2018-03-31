package service;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by stefano on 31/03/18.
 */
public class TemplateHealthCheck extends HealthCheck {

    private String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
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
