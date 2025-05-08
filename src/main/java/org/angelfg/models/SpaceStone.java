package org.angelfg.models;

import lombok.ToString;

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

}
