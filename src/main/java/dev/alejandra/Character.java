package dev.alejandra;

public class Character {

    private int health = 1000;
    private int level = 1;
    private boolean alive = true;   

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void receiveDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }



}
