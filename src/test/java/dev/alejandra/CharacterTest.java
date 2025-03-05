package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
