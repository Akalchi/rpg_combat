package dev.alejandra;

public class Prop {

    private int health;
    
    public Prop(int initialHealth) {
        this.health = initialHealth;
    }
    
    public int getHealth() {
        return health;
    }
    
    public boolean isDestroyed() {
        return false;
    }

    public void receiveDamage(int amount) {
        health -= amount;
    }

}
