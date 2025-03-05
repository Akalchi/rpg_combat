package dev.alejandra;

public interface DamageableTest {

    @Test
    public void testDamageableContract() {
        Damageable prop = new Prop(100);
        
        assertNotNull(prop.getHealth());
        assertFalse(prop.isDestroyed());
    }

}
