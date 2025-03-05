package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    private class TestCharacter extends Character {
        @Override
        public int getRange() {
            return 10; 
        }
    }

     @Test
    public void testCharacterInitialHealth() {

        Character character = new TestCharacter();
        
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testCharacterInitialLevel() {
      
        Character character = new TestCharacter();
        
        assertEquals(1, character.getLevel());
    }

     @Test
    public void testCharacterInitiallyAlive() {

        Character character = new TestCharacter();
        
        assertTrue(character.isAlive());
    }

    @Test
    public void testReceiveDamage() {
     
        Character character = new TestCharacter();
        
        character.receiveDamage(100);
        
        assertEquals(900, character.getHealth());
    }

     @Test
    public void testDieWhenHealthReachesZero() {
       
        Character character = new TestCharacter();
        
        character.receiveDamage(1100);
    
        assertEquals(0, character.getHealth());
        assertFalse(character.isAlive());
    }

    @Test
    public void testHeal() {
    
        Character character = new TestCharacter();
        character.receiveDamage(100);
        
        character.heal(50);
        
        assertEquals(950, character.getHealth());
    }
    
    @Test
    public void testCannotHealAboveMaxHealth() {
    
        Character character = new TestCharacter();
        
        character.heal(100);
        
        assertEquals(1000, character.getHealth());
    }
    
    @Test
    public void testCannotHealDeadCharacter() {
       
        Character character = new TestCharacter();
        character.receiveDamage(1100);
        
        character.heal(50);

        assertEquals(0, character.getHealth());
        assertFalse(character.isAlive());
    }

     @Test
    public void testCannotDamageSelf() {
        
        Character attacker = new TestCharacter();
        
        assertThrows(IllegalArgumentException.class, () -> {
    
           attacker.dealDamage(attacker, 100);

        });
    }

    @Test
    public void testOnlySelfCanHeal() {

        Character healer = new TestCharacter();
        Character patient = new TestCharacter();
        patient.receiveDamage(100);
        
        assertThrows(IllegalArgumentException.class, () -> {
           
            healer.heal(patient, 50);
        });
    }

    @Test
    public void testDamageReducedWhenTargetIs5LevelsHigher() {
       
        Character attacker = new TestCharacter();
        Character defender = new TestCharacter();
        defender.setLevel(6);
        
        attacker.dealDamage(defender, 100);
        
        assertEquals(950, defender.getHealth()); 
    }
    
    @Test
    public void testDamageIncreasedWhenAttackerIs5LevelsHigher() {
        
        Character attacker = new TestCharacter();
        Character defender = new TestCharacter();
        attacker.setLevel(6);
        
        attacker.dealDamage(defender, 100);
        
        assertEquals(850, defender.getHealth()); 
    }
}



    

