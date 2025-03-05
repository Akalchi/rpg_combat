package dev.alejandra;

public class RangedFighter extends Character {
    private static final int RANGED_RANGE = 20;
    
    @Override
    public int getRange() {
        return RANGED_RANGE;
    }
}