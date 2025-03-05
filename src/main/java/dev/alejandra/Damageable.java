package dev.alejandra;

public interface Damageable {

    public int getHealth();

    public boolean isDestroyed();

    public void receiveDamage(int amount);

}
