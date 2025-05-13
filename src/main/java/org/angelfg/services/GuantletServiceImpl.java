package org.angelfg.services;

import lombok.Setter;
import lombok.extern.java.Log;
import org.angelfg.models.Stone;

@Log
@Setter
public class GuantletServiceImpl implements GuantletService {

    // no es inyeccion de dependencias
    // private final Stone reality = MindStoneSingleton.getInstance();

    private Stone reality;
    private Stone soul;
    private Stone mind;
    private Stone power;
    private Stone space;
    private Stone time;

    @Override
    public void useGuantlet(String stoneName) {
        // log.info("Use stone: " + reality);

        switch (stoneName) {
            case "reality" -> log.info("Use stone: " + this.reality);
            case "soul" -> log.info("Use stone: " + this.soul);
            case "mind" -> log.info("Use stone: " + this.mind);
            case "power" -> log.info("Use stone: " + this.power);
            case "space" -> log.info("Use stone: " + this.space);
            case "time" -> log.info("Use stone: " + this.time);

            default -> throw new IllegalArgumentException("Invalid name");
        }
    }

    @Override
    public void useFullPower() {

        if (
            this.time != null &&
            this.reality != null &&
            this.space != null &&
            this.mind != null &&
            this.power != null &&
            this.soul != null
        ) {
            log.info("USING ALL POWER");
        } else {
            throw new IllegalStateException("Cant be using full power because service have field null");
        }

    }

    // Inyeccion de dependencias
    // o @Setter
//    public void setReality(Stone reality) {
//        this.reality = reality;
//    }

}
