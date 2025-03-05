package dev.alejandra;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    private int health = 1000;
    private int level = 1;
    private boolean alive = true; 
    private Set<String> factions = new HashSet<>();  

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

    public abstract int getRange();

     
    public void joinFaction(String faction) {
        factions.add(faction);
    }
    
    public void leaveFaction(String faction) {
        factions.remove(faction);
    }
    
    public boolean isInFaction(String faction) {
        return factions.contains(faction);
    }
    
    public boolean isAlly(Character other) {
        return factions.stream()
                .anyMatch(faction -> other.isInFaction(faction));
    }

    public void receiveDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }

    public void dealDamage(Character target, int amount) {
        dealDamage(target, amount, getRange());
    }

    public void dealDamage(Character target, int amount, int distance) {
        if (target == this) {
            throw new IllegalArgumentException("Cannot damage self");
        }
        
        if (distance > getRange()) {
            throw new IllegalArgumentException("Target is out of range");
        }

        if (isAlly(target)) {
            throw new IllegalArgumentException("Cannot damage ally");
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
    
    public void heal(Character target, int amount) {
        if (target != this && !isAlly(target)) {
            throw new IllegalArgumentException("Can only heal self or allies");
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

