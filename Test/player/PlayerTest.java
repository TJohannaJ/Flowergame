package player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player1;
    Player player2;
    @BeforeEach
    void setUp(){
        player1 = new Player("player1.png");
        player2 = new Player("player2.png");
    }

    @Test
    void initialization(){
        assertNotNull(player1.getImage());
        assertNotNull(player2.getImage());
    }

    @Test
    void testGetFlowers(){
        assertEquals(player1.getFlowers(), 10);
    }

    @Test
    void testPlant(){
        player1.plant();
        player1.plant();
        assertEquals(player1.getFlowers(), 8);
    }

    @Test
    void testPickUp(){
        player1.plant();
        player1.plant();
        player1.pickUp();
        assertEquals(player1.getFlowers(), 9);
    }

}