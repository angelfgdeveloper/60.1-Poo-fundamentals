package org.angelfg.services;

import lombok.extern.java.Log;
import org.angelfg.models.RealityStone;
import org.angelfg.models.Stone;

@Log
public class GuantletServiceImpl implements GuantletService {

    private final Stone reality = new RealityStone();

    @Override
    public void useGuantlet(String stoneName) {
        log.info("Use stone: " + reality);
    }

}
