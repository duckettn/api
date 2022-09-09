package com.nduckett.api.health;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

public class BasicHealthCheck extends NamedHealthCheck {
    @Override
    public String getName() {
        return "status";
    }

    @Override
    protected Result check() {
        return Result.healthy();
    }
}
