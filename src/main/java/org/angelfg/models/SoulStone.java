package org.angelfg.models;

import lombok.ToString;

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

}
