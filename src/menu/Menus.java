package menu;

import boards.*;
import player.*;
import javax.swing.*;

public abstract class Menus extends JFrame {
    public static Player player1 = new Player("player1.png") ;
    public static Player player2 = new Player("player2.png");

    public Menus(){
        setTitle("Planting Flowers");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player1.setX(2* Boards.cellSize);
        player1.setY(Boards.cellSize);
        player2.setX(23*Boards.cellSize);
        player2.setY(17*Boards.cellSize);
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}