package org.angelfg.singletons;

import lombok.extern.java.Log;
import org.angelfg.models.SpaceStone;

@Log
public class SpaceStoneSingleton {

    private static volatile SpaceStone spaceStoneInstance;

    private SpaceStoneSingleton() {}

    public static SpaceStone getInstance() {
        if (spaceStoneInstance == null) {
            log.info("Creating first instance: " + SpaceStoneSingleton.class);
            synchronized (SpaceStoneSingleton.class) {
                if (spaceStoneInstance == null) {
                    spaceStoneInstance = new SpaceStone();
                }
            }
        }

        return spaceStoneInstance;
    }

}
