package org.angelfg.factories;

import org.angelfg.models.SpaceStone;
import org.angelfg.models.Stone;
import org.angelfg.singletons.SpaceStoneSingleton;

import static org.angelfg.prototypes.Prototypes.spacePrototype;

public class SpaceStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return SpaceStoneSingleton.getInstance();
        }

        return spacePrototype.buildPrototype(new SpaceStone());
    }

}
