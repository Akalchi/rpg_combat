package dev.alejandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CharacterRangeTest {

   @Test
    public void testMeleeFighterRange() {
        MeleeFighter fighter = new MeleeFighter();
        assertEquals(2, fighter.getRange());
    }
    
    @Test
    public void testRangedFighterRange() {
        RangedFighter fighter = new RangedFighter();
        assertEquals(20, fighter.getRange());
    }
    
    @Test
    public void testMeleeFighterDamageWithinRange() {
        MeleeFighter attacker = new MeleeFighter();
        MeleeFighter defender = new MeleeFighter();
        
        attacker.dealDamage(defender, 100, 1);
        assertEquals(900, defender.getHealth());
    }
    
    @Test
    public void testMeleeFighterDamageOutOfRange() {
        MeleeFighter attacker = new MeleeFighter();
        MeleeFighter defender = new MeleeFighter();
        
        assertThrows(IllegalArgumentException.class, () -> {
            attacker.dealDamage(defender, 100, 3);
        });
    }
    
    @Test
    public void testRangedFighterDamageWithinRange() {
        RangedFighter attacker = new RangedFighter();
        RangedFighter defender = new RangedFighter();
        
        attacker.dealDamage(defender, 100, 15);
        assertEquals(900, defender.getHealth());
    }
    
    @Test
    public void testRangedFighterDamageOutOfRange() {
        RangedFighter attacker = new RangedFighter();
        RangedFighter defender = new RangedFighter();
        
        assertThrows(IllegalArgumentException.class, () -> {
            attacker.dealDamage(defender, 100, 21);
        });
    } 
}
