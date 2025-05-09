package org.angelfg.factories;

import org.angelfg.models.MindStone;
import org.angelfg.models.Stone;
import org.angelfg.singletons.MindStoneSingleton;

import static org.angelfg.prototypes.Prototypes.mindPrototype;

public class MindStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return MindStoneSingleton.getInstance();
        }

        return mindPrototype.buildPrototype(new MindStone());
    }

}
