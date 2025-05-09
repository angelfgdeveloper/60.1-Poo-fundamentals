package org.angelfg.factories;

import lombok.extern.java.Log;
import org.angelfg.models.Stone;

import java.util.Optional;

@Log
public abstract class ConfigurableStoneFactory {

    public abstract Stone createStone();

    protected boolean isSingleton() {
        final Optional<String> scopeOpt = Optional.of(System.getProperty("scope"));

        final String scope = scopeOpt.orElse("singleton");
        log.info("scope: " + scope);

        return "singleton".equals(scope);
    }

}
