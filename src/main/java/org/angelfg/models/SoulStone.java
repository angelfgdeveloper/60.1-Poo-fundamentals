package org.angelfg.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
public class SoulStone extends Stone {

    private static final String COLOR = "Orage";
    private static final String NAME = "Soul Stone";
    private static final String LOCATION = "Vormir";
    private static final int ENERGY_LEVEL = 3;

    public SoulStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void userPower() {
        // Business logic
        System.out.println("Total control: " + super.toString());
    }

    public SoulStone getPrototype() {

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
                return (SoulStone) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
