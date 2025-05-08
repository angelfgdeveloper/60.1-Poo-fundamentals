package org.angelfg.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class MindStone extends Stone {

    private static final String COLOR = "Yellow";
    private static final String NAME = "Mind Stone";
    private static final String LOCATION = "Scepter";
    private static final int ENERGY_LEVEL = 4;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void userPower() {
        // Business logic
        System.out.println("Mind control in stone: " + super.toString());
    }

    public MindStone getPrototype() {

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
                return (MindStone) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warning("Cant cast or read class ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
