package org.angelfg.prototypes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.angelfg.models.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Prototypes {
    public static StonePrototype<MindStone> mindPrototype = MindStone::getPrototype;
    public static StonePrototype<PowerStone> powerPrototype = PowerStone::getPrototype;
    public static StonePrototype<RealityStone> realityPrototype = RealityStone::getPrototype;
    public static StonePrototype<SoulStone> soulPrototype = SoulStone::getPrototype;
    public static StonePrototype<SpaceStone> spacePrototype = SpaceStone::getPrototype;
    public static StonePrototype<TimeStone> timePrototype = TimeStone::getPrototype;
}
