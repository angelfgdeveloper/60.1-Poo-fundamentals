package org.angelfg.factories;

import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;
import org.angelfg.singletons.RealityStoneSingleton;

import static org.angelfg.prototypes.Prototypes.realityPrototype;

public class RealityStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return RealityStoneSingleton.getInstance();
        }

        return realityPrototype.buildPrototype(new RealityStone());
    }

}
