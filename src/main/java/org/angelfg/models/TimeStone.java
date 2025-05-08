package org.angelfg.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
public class TimeStone extends Stone {

    private static final String COLOR = "Green";
    private static final String NAME = "Time Stone";
    private static final String LOCATION = "Agamotto";
    private static final int ENERGY_LEVEL = 9;

    public TimeStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void userPower() {
        // Business logic
        System.out.println("Control time: " + super.toString());
    }

    public TimeStone getPrototype() {

        try (
                // convert object into bytes
                final ByteArrayOutputStream bos = new ByteArrayOutputStream();
                final ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            // Serialize object (clone)
            oos.writeObject(this);
            oos.flush(); // vacia el buffer

            try (
                    // Deserialize
                    final ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                    final ObjectInputStream ois = new ObjectInputStream(bis);
            ) {
                // Returning and Cast
                return (TimeStone) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
