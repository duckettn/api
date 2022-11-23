package com.nduckett.api.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.logging.LoggingFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static net.logstash.logback.argument.StructuredArguments.kv;


@Path("/")
public class RootResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootResource.class);

    @GET
    @Timed
    public String get() {
        LOGGER.info("Welcoming", kv("name", "Nathan"));
        return "Welcome";
    }
}
