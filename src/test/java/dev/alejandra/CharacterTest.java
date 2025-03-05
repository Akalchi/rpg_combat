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

}
