package org.angelfg.services;

import lombok.extern.java.Log;
import org.angelfg.models.Stone;
import org.angelfg.singletons.MindStoneSingleton;

@Log
public class GuantletServiceImpl implements GuantletService {

    private final Stone reality = MindStoneSingleton.getInstance();

    @Override
    public void useGuantlet(String stoneName) {
        log.info("Use stone: " + reality);
    }

}
