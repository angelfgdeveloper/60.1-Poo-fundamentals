package org.angelfg.prototypes;

import org.angelfg.models.Stone;

@FunctionalInterface
public interface StonePrototype<S extends Stone> {
    S buildPrototype(S stone);
}
