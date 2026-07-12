package boards;

import menu.Menus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;

import static org.junit.jupiter.api.Assertions.*;

class Boards_TwoPlayerTest {
    Boards_TwoPlayer board;

    @BeforeEach
    void setUp() {
        board = new Boards_TwoPlayer();
    }

    @Test
    void testGetTileTable() {
        assertEquals(board.getTileTable(6,6), "n");
    }

    @Test
    void testSetTileTable() {
        board.setTileTable(6, 6, "F");
        assertEquals(board.getTileTable(6,6), "F");
    }
}