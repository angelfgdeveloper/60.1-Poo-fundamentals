package org.angelfg.services;

import lombok.extern.java.Log;
import org.angelfg.models.Stone;
import org.angelfg.singletons.MindStoneSingleton;

@Log
public class GuantletServiceImpl implements GuantletService {

    // no es inyeccion de dependencias
    // private final Stone reality = MindStoneSingleton.getInstance();

    private Stone reality;

    @Override
    public void useGuantlet(String stoneName) {
        // log.info("Use stone: " + reality);

        switch (stoneName) {
            case "reality" -> log.info("Use stone: " + reality);
            default -> throw new IllegalArgumentException("Invalid name");
        }
    }

    @Override
    public void useFullPower() {

    }

    // Inyeccion de dependencias
    // o @Setter
    public void setReality(Stone reality) {
        this.reality = reality;
    }

}
