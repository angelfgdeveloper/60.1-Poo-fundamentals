package org.angelfg.singletons;

import lombok.extern.java.Log;
import org.angelfg.models.PowerStone;

@Log
public class PowerStoneSingleton {

    private static volatile PowerStone powerStoneInstance;

    private PowerStoneSingleton() {}

    private static PowerStone getInstance() {
        if (powerStoneInstance == null) {
            log.info("Creating first instance: " + PowerStoneSingleton.class);
            synchronized (PowerStoneSingleton.class) {
                if (powerStoneInstance == null) {
                    powerStoneInstance = new PowerStone();
                }
            }
        }

        return powerStoneInstance;
    }

}
