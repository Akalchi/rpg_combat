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

    public void setLevel(int level) {
        this.level = level;
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

    public void dealDamage(Character target, int amount) {
        if (target == this) {
            throw new IllegalArgumentException("Cannot damage self");
        }
        
        int damageAmount = calculateDamage(target, amount);
        target.receiveDamage(damageAmount);
    }

    private int calculateDamage(Character target, int amount) {
        int levelDifference = Math.abs(this.level - target.level);
        
        if (levelDifference >= 5) {
            if (this.level > target.level) {
                return (int) (amount * 1.5); 
            } else {
                return amount / 2; 
            }
        }
        
        return amount;
    }
    
    public void heal(Character target,int amount) {
        if (target != this) {
            throw new IllegalArgumentException("Can only heal self");
        }
        
        if (!target.alive) return;
        
        target.health += amount;
        if (target.health > 1000) {
            target.health = 1000;
        }
    }

    public void heal(int amount) {
        heal(this, amount);
    }
 
}

