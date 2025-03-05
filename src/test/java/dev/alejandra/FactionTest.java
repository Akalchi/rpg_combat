package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FactionTest {

     @Test
    public void testCharacterStartsWithNoFactions() {
      
        MeleeFighter character = new MeleeFighter();
        
        assertFalse(character.isInFaction("Any"));
    }
    
    @Test
    public void testJoinFaction() {
       
        MeleeFighter character = new MeleeFighter();
        
        character.joinFaction("Rebels");
       
        assertTrue(character.isInFaction("Rebels"));
    }
    
    @Test
    public void testLeaveFaction() {
      
        MeleeFighter character = new MeleeFighter();
        character.joinFaction("Rebels");
      
        character.leaveFaction("Rebels");
      
        assertFalse(character.isInFaction("Rebels"));
    }
    
    @Test
    public void testCharacterCanBelongToMultipleFactions() {
       
        MeleeFighter character = new MeleeFighter();
      
        character.joinFaction("Rebels");
        character.joinFaction("Alliance");
       
        assertTrue(character.isInFaction("Rebels"));
        assertTrue(character.isInFaction("Alliance"));
    }
    
    @Test
    public void testAlliesCannotDamageEachOther() {
        
        MeleeFighter attacker = new MeleeFighter();
        MeleeFighter defender = new MeleeFighter();
        
        attacker.joinFaction("Rebels");
        defender.joinFaction("Rebels");
        
        assertThrows(IllegalArgumentException.class, () -> {
           
            attacker.dealDamage(defender, 100, 1);
        });
    }
    
    @Test
    public void testEnemiesCanDamageEachOther() {
       
        MeleeFighter attacker = new MeleeFighter();
        MeleeFighter defender = new MeleeFighter();
        
        attacker.joinFaction("Rebels");
        defender.joinFaction("Empire");
        
        attacker.dealDamage(defender, 100, 1);
        
        assertEquals(900, defender.getHealth());
    }
    
    @Test
    public void testAlliesCanHealEachOther() {
     
        MeleeFighter healer = new MeleeFighter();
        MeleeFighter patient = new MeleeFighter();
        
        healer.joinFaction("Rebels");
        patient.joinFaction("Rebels");
        
        patient.receiveDamage(100);
        
        healer.heal(patient, 50);
        
        assertEquals(950, patient.getHealth());
    }
    
    @Test
    public void testCannotHealNonAllies() {
       
        MeleeFighter healer = new MeleeFighter();
        MeleeFighter patient = new MeleeFighter();
        
        healer.joinFaction("Rebels");
        patient.joinFaction("Empire");
        
        patient.receiveDamage(100);
       
        assertThrows(IllegalArgumentException.class, () -> {
            
            healer.heal(patient, 50);
        });
    }

}
