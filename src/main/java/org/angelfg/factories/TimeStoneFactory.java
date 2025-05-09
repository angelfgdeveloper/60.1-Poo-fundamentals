package org.angelfg.factories;

import org.angelfg.models.Stone;
import org.angelfg.models.TimeStone;
import org.angelfg.singletons.TimeStoneSingleton;

import static org.angelfg.prototypes.Prototypes.timePrototype;

public class TimeStoneFactory extends ConfigurableStoneFactory {

    @Override
    public Stone createStone() {

        if (super.isSingleton()) {
            return TimeStoneSingleton.getInstance();
        }

        return timePrototype.buildPrototype(new TimeStone());
    }

}
