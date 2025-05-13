package org.angelfg;

import org.angelfg.factories.PowerStoneFactory;
import org.angelfg.factories.RealityStoneFactory;
import org.angelfg.factories.TimeStoneFactory;
import org.angelfg.models.MindStone;
import org.angelfg.models.PowerStone;
import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;
import org.angelfg.prototypes.Prototypes;
import org.angelfg.services.GuantletServiceImpl;
import org.angelfg.singletons.RealityStoneSingleton;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

//            example_1();

        System.setProperty("scope", "singleton");

        var realityFactory = new RealityStoneFactory();
        var timeFactory = new TimeStoneFactory();

        final GuantletServiceImpl guantletService = new GuantletServiceImpl();
        // Inyeccion de depdencias por setter
        guantletService.setReality(realityFactory.createStone());
        guantletService.setTime(timeFactory.createStone());

        guantletService.useGuantlet("reality");
        guantletService.useGuantlet("time");
        guantletService.useGuantlet("soul");

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