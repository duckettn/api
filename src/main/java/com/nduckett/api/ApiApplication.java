package com.nduckett.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class ApiApplication extends Application<ApiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "Duckett API";
    }

    @Override
    public void initialize(final Bootstrap<ApiConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .build());

    }

    @Override
    public void run(final ApiConfiguration configuration,
                    final Environment environment) {

    }

}