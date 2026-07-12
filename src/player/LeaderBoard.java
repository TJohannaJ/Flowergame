package player;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
//Ebben az osztalyban van a fajlba iras es olvasas leirva (json-nal), egy eredmenylistat vezet az eddigi osszes lementeni kivant
public class LeaderBoard {
    //
    private ArrayList<Game> games;

    public LeaderBoard() {
        this.games = new ArrayList<>();
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
        this.games.sort(Comparator.comparingLong(Game::getScore).reversed());
    }

    public void addGame(Game game) {
        games.add(game);
        games.sort(Comparator.comparingLong(Game::getScore).reversed());
    }

    public void saveToJsonFileAsText(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), this);
            System.out.println("You can find your score in the file named: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeaderBoard loadFromTextFile(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filename);

            if (file.exists()) {
                // beolvassa a JSON tartalmat a .txt fájlból
                byte[] encoded = Files.readAllBytes(file.toPath());
                String jsonContent = new String(encoded, StandardCharsets.UTF_8);

                // a JSON-t LeaderBoard-dá alakítja
                return objectMapper.readValue(jsonContent, LeaderBoard.class);
            } else {
                // ha nem létezik a fájl, akkor készít egy új LeaderBoard-ot
                return new LeaderBoard();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "Leaderboard{" +
                "games=" + games +
                '}';
    }
}
