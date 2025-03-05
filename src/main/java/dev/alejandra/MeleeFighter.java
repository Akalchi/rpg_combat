package dev.alejandra;


public class MeleeFighter extends Character {
    private static final int MELEE_RANGE = 2;
    
    @Override
    public int getRange() {
        return MELEE_RANGE;
    }
}