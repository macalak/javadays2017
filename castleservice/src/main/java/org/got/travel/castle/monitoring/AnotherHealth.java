package org.got.travel.castle.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AnotherHealth implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().build();
    }
}
