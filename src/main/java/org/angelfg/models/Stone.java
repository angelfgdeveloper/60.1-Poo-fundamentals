package org.angelfg.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Stone implements Serializable {

    protected String color;
    protected String name;
    protected String location;
    protected Integer energyLevel;
    protected Integer numberOfSlides;

    private static final int NUMBER_SIDES = 6;

    public Stone(
            String color,
            String name,
            String location,
            Integer energyLevel
    ) {
        this.color = color;
        this.name = name;
        this.location = location;
        this.energyLevel = energyLevel;
        this.numberOfSlides = NUMBER_SIDES;
    }

    public abstract void userPower();

    public void clear() {
        System.out.println("Cleaning stone");
    }

}
