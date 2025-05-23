package org.angelfg;

import org.angelfg.configs.StoneContext;
import org.angelfg.factories.*;
import org.angelfg.models.MindStone;
import org.angelfg.models.PowerStone;
import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;
import org.angelfg.prototypes.Prototypes;
import org.angelfg.services.GuantletServiceImpl;
import org.angelfg.services.GuantletServiceImpl2;
import org.angelfg.singletons.RealityStoneSingleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        inversion_control();
    }

    private static void inversion_control() {
        final var gauntletService = StoneContext.setContext(
                pre -> System.out.println("Do something 1"),
                post -> System.out.println("Do something 2")
        );

        gauntletService.useGuantlet("power");

        gauntletService.useFullPower();

        StoneContext.destroyContext(gauntletService);
    }

    private static void via_contructor() {
        System.setProperty("scope", "singleton");

        var realityFactory = new RealityStoneFactory();
        var soulFactory = new SoulStoneFactory();
        var mindFactory = new MindStoneFactory();
        var powerFactory = new PowerStoneFactory();
        var spaceFactory = new SpaceStoneFactory();
        var timeFactory = new TimeStoneFactory();

        // DI por contructor
        final GuantletServiceImpl guantletService = new GuantletServiceImpl(
                realityFactory.createStone(),
                soulFactory.createStone(),
                mindFactory.createStone(),
                powerFactory.createStone(),
                spaceFactory.createStone(),
                timeFactory.createStone()
        );

        // Inyeccion de depdencias por setter
//        guantletService.setReality(realityFactory.createStone());
//        guantletService.setTime(timeFactory.createStone());

        guantletService.useGuantlet("reality");
        guantletService.useGuantlet("time");
        guantletService.useGuantlet("soul");

        guantletService.useFullPower();
    }

    private static void java_reflection() {
        System.setProperty("scope", "singleton");

        var realityFactory = new RealityStoneFactory();
        var soulFactory = new SoulStoneFactory();
        var mindFactory = new MindStoneFactory();
        var powerFactory = new PowerStoneFactory();
        var spaceFactory = new SpaceStoneFactory();
        var timeFactory = new TimeStoneFactory();

        var reality = realityFactory.createStone();
        var soul = soulFactory.createStone();
        var mind = mindFactory.createStone();
        var power = powerFactory.createStone();
        var space = spaceFactory.createStone();
        var time = timeFactory.createStone();

        Map<String, Stone> instances = Map.of(
                "reality", reality,
                "soul", soul,
                "mind", mind,
                "power", power,
                "space", space,
                "time", time
        );

        final GuantletServiceImpl2 guantletService = new GuantletServiceImpl2();

        // DI by field
        guantletService.setStones(instances);

        guantletService.useGuantlet("power");
        guantletService.useFullPower();
    }

    private static void example_1() {
        //        final var mind = new MindStone(); // OK
//        final Stone power = new PowerStone(); // OK
//        final RealityStone reality = new RealityStone(); // mala practica (funciona)
//
//        mind.userPower();
//        System.out.println("---");
//        power.userPower();
//        System.out.println("---");
//        reality.userPower();

        // SINGLETON PRUEBA
//        var r1 = RealityStoneSingleton.getInstance();
//        var r2 = RealityStoneSingleton.getInstance();
//        var r3 = RealityStoneSingleton.getInstance();
//
//        // == apunta en la direccion de memoria
//        if (r1 == r2 && r2 == r3) {
//            System.out.println("Singleton!!!");
//        }
//
//        final var guantletService = new GuantletServiceImpl();
////        guantletService.reality = null;
//        guantletService.useGuantlet("");
//
//        // Objetos en memoria diferente
//        final var mind = new MindStone();
//        System.out.println(mind);
//        System.out.println(System.identityHashCode(mind)); // 764308918
//
//        // instance 2
////        final var mindProto = mind.getPrototype();
////        System.out.println(mindProto);
////        System.out.println(System.identityHashCode(mindProto)); // 1476011703
//
//        // Mejor practico porque utilizamos principios solid para no llamar a la clase en si
//        final var mindProto = Prototypes.mindPrototype.buildPrototype(mind);
//        System.out.println(mindProto);
//        System.out.println(System.identityHashCode(mindProto));
//
//        // instance 3
//        final var mindProto3 = Prototypes.mindPrototype.buildPrototype(mind);
//        System.out.println(mindProto3);
//        System.out.println(System.identityHashCode(mindProto3));
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        // Factory Method
//        System.setProperty("scope", "singleton");
//        System.setProperty("scope", "prototype");
//
//        final var timeStoneFactory = new TimeStoneFactory();
//        var timeStone = timeStoneFactory.createStone();
//
//        final var powerStoneFactory = new PowerStoneFactory();
//        var powerStone = powerStoneFactory.createStone();
//
//        final var realityStoneFactory = new RealityStoneFactory();
//        var factoryStone = realityStoneFactory.createStone();
//
//        System.out.println(timeStone);
//        System.out.println(powerStone);
//        System.out.println(factoryStone);

    }

}