package boards;

import player.*;
import javax.swing.*;
import java.awt.*;

public class DrawPlayers extends JComponent {
    public DrawPlayers(Player p, int x, int y){
        p.setX(x);
        p.setY(y);
    }

    public void drawPlayer(Player p, Graphics g){
        g.drawImage(p.getImage(), p.getX(), p.getY(), Boards.cellSize, Boards.cellSize, this);
    }
}