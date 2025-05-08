package org.angelfg.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
public class SpaceStone extends Stone {

    private static final String COLOR = "Blue";
    private static final String NAME = "Space Stone";
    private static final String LOCATION = "Tesseract";
    private static final int ENERGY_LEVEL = 7;

    public SpaceStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void userPower() {
        // Business logic
        System.out.println("Manipulate all space: " + super.toString());
    }

    public SpaceStone getPrototype() {

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
                return (SpaceStone) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
