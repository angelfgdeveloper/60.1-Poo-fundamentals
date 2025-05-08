package org.angelfg.singletons;

import lombok.extern.java.Log;
import org.angelfg.models.SoulStone;

@Log
public class SoulStoneSingleton {

    private static volatile SoulStone soulStoneInstance;

    private SoulStoneSingleton() {}

    public static SoulStone getInstance() {
        if (soulStoneInstance == null) {
            log.info("Creating first instance: " + SoulStoneSingleton.class);
            synchronized (SoulStoneSingleton.class) {
                if (soulStoneInstance == null) {
                    soulStoneInstance = new SoulStone();
                }
            }
        }

        return soulStoneInstance;
    }

}
