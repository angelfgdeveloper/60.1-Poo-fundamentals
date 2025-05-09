package org.angelfg;

import org.angelfg.models.MindStone;
import org.angelfg.models.PowerStone;
import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;
import org.angelfg.prototypes.Prototypes;
import org.angelfg.services.GuantletServiceImpl;
import org.angelfg.singletons.RealityStoneSingleton;

public class Main {

    public static void main(String[] args) {

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

        final var guantletService = new GuantletServiceImpl();
//        guantletService.reality = null;
        guantletService.useGuantlet("");

        // Objetos en memoria diferente
        final var mind = new MindStone();
        System.out.println(mind);
        System.out.println(System.identityHashCode(mind)); // 764308918

        // instance 2
//        final var mindProto = mind.getPrototype();
//        System.out.println(mindProto);
//        System.out.println(System.identityHashCode(mindProto)); // 1476011703

        final var mindProto = Prototypes.mindPrototype.buildPrototype(mind);
        System.out.println(mindProto);
        System.out.println(System.identityHashCode(mindProto));

        // instance 3
        final var mindProto3 = Prototypes.mindPrototype.buildPrototype(mind);
        System.out.println(mindProto3);
        System.out.println(System.identityHashCode(mindProto3));

    }

}