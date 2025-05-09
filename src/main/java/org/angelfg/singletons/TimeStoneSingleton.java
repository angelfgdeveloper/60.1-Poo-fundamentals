package org.angelfg.singletons;

import lombok.extern.java.Log;
import org.angelfg.models.TimeStone;

@Log
public class TimeStoneSingleton {

    private static volatile TimeStone timeStoneInstance;

    private TimeStoneSingleton() {}

    public static TimeStone getInstance() {
        if (timeStoneInstance == null) {
            log.info("Creating first instance: " + TimeStoneSingleton.class);
            synchronized (TimeStoneSingleton.class) {
                if (timeStoneInstance == null) {
                    timeStoneInstance = new TimeStone();
                }
            }
        }

        return timeStoneInstance;
    }

}
