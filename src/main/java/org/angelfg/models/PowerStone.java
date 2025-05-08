package org.angelfg.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
public class PowerStone extends Stone {

    private static final String COLOR = "Purple";
    private static final String NAME = "Power Stone";
    private static final String LOCATION = "Xandar";
    private static final int ENERGY_LEVEL = 10;

    public PowerStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void userPower() {
        // Business logic
        System.out.println("Increase power and energy: " + super.toString());
    }

    public PowerStone getPrototype() {

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
                return (PowerStone) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
