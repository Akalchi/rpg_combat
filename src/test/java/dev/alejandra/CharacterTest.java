package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {

     @Test
    public void testCharacterInitialHealth() {

        Character character = new Character();
        
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testCharacterInitialLevel() {
      
        Character character = new Character();
        
        assertEquals(1, character.getLevel());
    }

     @Test
    public void testCharacterInitiallyAlive() {

        Character character = new Character();
        
        assertTrue(character.isAlive());
    }

    @Test
    public void testReceiveDamage() {
     
        Character character = new Character();
        
        character.receiveDamage(100);
        
        assertEquals(900, character.getHealth());
    }

     @Test
    public void testDieWhenHealthReachesZero() {
       
        Character character = new Character();
        
        character.receiveDamage(1100);
    
        assertEquals(0, character.getHealth());
        assertFalse(character.isAlive());
    }

    @Test
    public void testHeal() {
    
        Character character = new Character();
        character.receiveDamage(100);
        
        character.heal(50);
        
        assertEquals(950, character.getHealth());
    }
    
    @Test
    public void testCannotHealAboveMaxHealth() {
    
        Character character = new Character();
        
        character.heal(100);
        
        assertEquals(1000, character.getHealth());
    }
    
    @Test
    public void testCannotHealDeadCharacter() {
       
        Character character = new Character();
        character.receiveDamage(1100);
        
        character.heal(50);
        
        assertEquals(0, character.getHealth());
        assertFalse(character.isAlive());
    }
}

    
}
