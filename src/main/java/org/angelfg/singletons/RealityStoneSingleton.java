package org.angelfg.singletons;

import lombok.extern.java.Log;
import org.angelfg.models.RealityStone;

@Log
public class RealityStoneSingleton {

    private static volatile RealityStone realityStoneInstance;

    private RealityStoneSingleton() {}

    public static RealityStone getInstance() {
        if (realityStoneInstance == null) {
            log.info("Creating first instance: " + RealityStoneSingleton.class);
            synchronized (RealityStoneSingleton.class) {
                if (realityStoneInstance == null) {
                    realityStoneInstance = new RealityStone();
                }
            }
        }

        return realityStoneInstance;
    }

}
