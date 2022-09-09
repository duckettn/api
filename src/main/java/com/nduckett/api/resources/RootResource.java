package com.nduckett.api.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RootResource {

    @GET
    @Timed
    public String get() {
        return "Welcome";
    }
}
