package org.angelfg.models;

import lombok.ToString;

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

}
