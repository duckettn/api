package com.nduckett.api;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Injector;
import com.nduckett.api.core.metrics.MetricReporter;
import com.nduckett.api.resources.RootResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.util.concurrent.TimeUnit;

public class ApiApplication extends Application<ApiConfiguration> {
    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiApplication.class);

    private GuiceBundle guiceBundle;

    public static void main(final String[] args) throws Exception {
        new ApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "Duckett API";
    }

    @Override
    public void initialize(final Bootstrap<ApiConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .build();
        bootstrap.addBundle(guiceBundle);

    }

    @Override
    public void run(final ApiConfiguration configuration,
                    final Environment environment) throws JsonProcessingException {
        Injector injector = guiceBundle.getInjector();
        injector.getInstance(MetricReporter.class).register();

        Counter hello = injector.getInstance(MetricRegistry.class).counter("hello");
        LOGGER.info(objectMapper.writeValueAsString(ImmutableMap.of(
                "name", "nathan",
                "message", "Hello World!!"
        )));
        hello.inc();
    }

}