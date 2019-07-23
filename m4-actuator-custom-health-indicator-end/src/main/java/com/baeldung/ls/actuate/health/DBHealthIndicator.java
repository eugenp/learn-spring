package com.baeldung.ls.actuate.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class DBHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isDbUp()) {
            return Health.up()
                .build();
        } else {
            return Health.down()
                .withDetail("Error Code", 503)
                .build();
        }
    }

    private boolean isDbUp() {
        return false;
    }

}
