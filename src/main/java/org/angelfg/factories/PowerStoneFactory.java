package org.angelfg.factories;

import org.angelfg.models.PowerStone;
import org.angelfg.models.Stone;
import org.angelfg.singletons.PowerStoneSingleton;

import static org.angelfg.prototypes.Prototypes.powerPrototype;

public class PowerStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return PowerStoneSingleton.getInstance();
        }

        return powerPrototype.buildPrototype(new PowerStone());
    }

}
