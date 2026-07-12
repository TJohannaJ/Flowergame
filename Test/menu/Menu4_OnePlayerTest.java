package menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Menu4_OnePlayerTest {
    Menu4_OnePlayer menu;
    @BeforeEach
    void setUp() {
        menu = new Menu4_OnePlayer();
    }

    @Test
    void testWall() {
        boolean b = menu.wall(0,0);
        assertTrue(b);
    }
}