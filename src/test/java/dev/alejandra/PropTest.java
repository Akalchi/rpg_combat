package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PropTest {

    @Test
    public void testPropInitialization() {
        
        Prop tree = new Prop(2000);
        
        assertEquals(2000, tree.getHealth());
        assertFalse(tree.isDestroyed());
    }

    @Test
    public void testPropReceiveDamage() {
   
    Prop prop = new Prop(100);
    
    prop.receiveDamage(50);
    
    assertEquals(50, prop.getHealth());
    }
    
}    

