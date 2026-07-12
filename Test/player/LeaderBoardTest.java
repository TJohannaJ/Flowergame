package player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaderBoardTest {
    private File testFile;

    @Test
    void testGetGames() {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.addGame(new Game("Player1", 1000));
        Game game = new Game("Player1", 1000);
        assertNotEquals(leaderBoard.getGames(),game);

    }

    @Test
    void testAddGame() {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.addGame(new Game("Player1", 1000));
        leaderBoard.addGame(new Game("Player2", 800));

        assertEquals("Player1", leaderBoard.getGames().get(0).getName());
        assertEquals(1000, leaderBoard.getGames().get(0).getScore());
        assertEquals("Player2", leaderBoard.getGames().get(1).getName());
        assertEquals(800, leaderBoard.getGames().get(1).getScore());
    }

    @Test
    void testLoadFromTextFile() {
        LeaderBoard leaderBoard = LeaderBoard.loadFromTextFile("nonexistentfile.txt");
        assertNotNull(leaderBoard);
        assertEquals(0, leaderBoard.getGames().size());
    }
}