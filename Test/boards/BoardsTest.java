package boards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardsTest {
    Boards_OnePlayer board;
    @BeforeEach
    void setUp() {
        board = new Boards_OnePlayer();
    }

    @Test
    void testRandomGenerator() {
        int num = board.randomGenerator();
        assertTrue(num == 1 || num == 2);
    }
}