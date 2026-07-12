package player;

public class Game {
    private String name;
    private long score;
    public Game() {

    }
    public Game(String n, long sc){
        name = n;
        score = sc;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScore(){
        return score;
    }

    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
