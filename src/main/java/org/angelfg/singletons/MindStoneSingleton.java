package org.angelfg.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.angelfg.models.MindStone;

@Log
// @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MindStoneSingleton {

    // volatile visible para todos los hilos
    // Para uso en concurrencia
    private static volatile MindStone mindStoneInstance;

    // constructor privado
    private MindStoneSingleton() {}

    // 500 hilos con tomcat
    public static MindStone getInstance() {
        if (mindStoneInstance == null) {
            synchronized (MindStoneSingleton.class) { // Manejamos concurrencia
                if (mindStoneInstance == null) {
                    mindStoneInstance = new MindStone();
                }
            }
        }

        return mindStoneInstance;
    }

}
