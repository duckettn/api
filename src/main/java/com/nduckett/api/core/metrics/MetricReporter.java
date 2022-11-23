package com.nduckett.api.core.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.google.inject.Inject;

import java.util.concurrent.TimeUnit;

public class MetricReporter {

    private final MetricRegistry metricRegistry;

    @Inject
    public MetricReporter(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    public void register() {
        GraphiteReporter reporter = GraphiteReporter.forRegistry(this.metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(new Graphite("192.168.1.254", 2003));
        reporter.start(1, TimeUnit.MINUTES);
    }
}
