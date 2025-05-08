package org.angelfg;

import org.angelfg.models.MindStone;
import org.angelfg.models.PowerStone;
import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;
import org.angelfg.services.GuantletServiceImpl;

public class Main {

    public static void main(String[] args) {

        final var mind = new MindStone(); // OK
        final Stone power = new PowerStone(); // OK
        final RealityStone reality = new RealityStone(); // mala practica (funciona)

        mind.userPower();
        System.out.println("---");
        power.userPower();
        System.out.println("---");
        reality.userPower();

        final var guantletService = new GuantletServiceImpl();
//        guantletService.reality = null;
        guantletService.useGuantlet("");

    }

}