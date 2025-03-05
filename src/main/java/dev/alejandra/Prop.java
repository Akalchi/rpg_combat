package dev.alejandra;

public class Prop {

    private int health;
    
    private boolean destroyed = false;
    
    public Prop(int initialHealth) {
        this.health = initialHealth;
    }
    
    public int getHealth() {
        return health;
    }
    
    public boolean isDestroyed() {
        return destroyed;
    }

    public void receiveDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
            destroyed = true;
        }
    
    }
}
