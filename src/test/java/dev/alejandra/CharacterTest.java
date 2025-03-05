package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
