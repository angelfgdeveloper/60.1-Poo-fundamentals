package org.angelfg.configs;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.angelfg.factories.*;
import org.angelfg.models.*;
import org.angelfg.services.GuantletService;
import org.angelfg.services.GuantletServiceImpl3;

import java.util.Map;
import java.util.function.Consumer;

// IoC -> Inversion del control
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoneContext {

    public static GuantletService setContext(Consumer<Void> preConstruct, Consumer<Void> postConstruct) {
        // Set scope
        log.info("Ioc set scope");
        System.setProperty("scope", "singleton");

        // @PreConstruct
        log.info("Ioc executing PreConstruct");
        preConstruct.accept(null);

        // Ioc
        log.info("Ioc creating factories");
        var realityFactory = new RealityStoneFactory();
        var timeFactory = new TimeStoneFactory();
        var soulFactory = new SoulStoneFactory();
        var powerFactory = new PowerStoneFactory();
        var spaceFactory = new SpaceStoneFactory();
        var mindFactory = new MindStoneFactory();

        log.info("Ioc instance objects");
        RealityStone reality = (RealityStone) realityFactory.createStone();
        TimeStone time = (TimeStone) timeFactory.createStone();
        SoulStone soul = (SoulStone) soulFactory.createStone();
        PowerStone power = (PowerStone) powerFactory.createStone();
        SpaceStone space = (SpaceStone) spaceFactory.createStone();
        MindStone mind = (MindStone) mindFactory.createStone();

        log.info("IoC loading GauntletServiceImpl in container");
        final var gauntletService = new GuantletServiceImpl3();

        Map<String, Stone> instances = Map.of(
                "reality", reality,
                "soul", soul,
                "mind", mind,
                "power", power,
                "space", space,
                "time", time
        );

        log.info("IoC DI on GauntletServiceImpl");
        gauntletService.setStones(instances);

        log.info("IoC executing PostConstruct");
        //@PostConstruct
        postConstruct.accept(null);

        return gauntletService;
    }

    public static void destroyContext(GuantletService gauntletService) {

        log.info("Cleaning context");
        if (gauntletService instanceof GuantletServiceImpl3) {
            ((GuantletServiceImpl3) gauntletService).getMind().clear();
            ((GuantletServiceImpl3) gauntletService).getTime().clear();
            ((GuantletServiceImpl3) gauntletService).getSoul().clear();
            ((GuantletServiceImpl3) gauntletService).getPower().clear();
            ((GuantletServiceImpl3) gauntletService).getReality().clear();
        }

        log.info("Cleaning properties");
        System.clearProperty("scope");
    }

}
