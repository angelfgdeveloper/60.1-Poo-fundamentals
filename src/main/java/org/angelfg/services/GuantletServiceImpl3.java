package org.angelfg.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.angelfg.models.*;

import java.lang.reflect.Field;
import java.util.Map;

@Log
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GuantletServiceImpl3 implements GuantletService {

    private RealityStone reality;
    private SoulStone soul;
    private MindStone mind;
    private PowerStone power;
    private SpaceStone space;
    private TimeStone time;

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

    // DI via propiedad
    public void setStones(Map<String, Stone> stones) {

        stones.forEach((fieldName, stoneDependency) -> {

            try {

                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true); // quita el private de java reflection
                field.set(this, stoneDependency); // Depdenncy inyection via reflection

                log.info("Dependency injection by field " + fieldName);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.warning("Error on DI by fields");
            }

        });

    }

}
