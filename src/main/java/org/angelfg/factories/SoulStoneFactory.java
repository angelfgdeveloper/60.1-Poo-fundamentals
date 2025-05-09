package org.angelfg.factories;

import org.angelfg.models.SoulStone;
import org.angelfg.models.Stone;
import org.angelfg.singletons.SoulStoneSingleton;

import static org.angelfg.prototypes.Prototypes.soulPrototype;

public class SoulStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return SoulStoneSingleton.getInstance();
        }

        return soulPrototype.buildPrototype(new SoulStone());
    }

}
