package menu;

import boards.*;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu4_TwoPlayer extends Menus{
    private Boards_TwoPlayer b1;
    public Menu4_TwoPlayer(){
        super();
        setSize(850, 740);

        JLabel player1name = new JLabel(getPlayer1().getName());
        FlowersLeftPanel flower1 = new FlowersLeftPanel(player1);
        JLabel player2name = new JLabel(getPlayer2().getName());
        FlowersLeftPanel flower2 = new FlowersLeftPanel(player2);
        JPanel top = new JPanel();
        b1 = new Boards_TwoPlayer();
        JPanel bottom = b1;

        top.setSize(850,100);
        b1.set_time();
        addKeyListener(new P1KeyListener());
        addKeyListener(new P2KeyListener());

        top.add(player1name);
        top.add(flower1);
        top.add(player2name);
        top.add(flower2);

        add(top, BorderLayout.NORTH);
        add(bottom);
        add(bottom, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class P1KeyListener implements KeyListener {

        public void keyPressed(KeyEvent k) {
            switch(k.getKeyCode()){
                case KeyEvent.VK_UP -> {
                    if(!wall(Menus.player1.getX()/Boards.cellSize, (Menus.player1.getY()/Boards.cellSize)-1)){
                        Menus.player1.setY(Menus.player1.getY() -Boards.cellSize);
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    if(!wall(Menus.player1.getX()/Boards.cellSize, (Menus.player1.getY()/Boards.cellSize)+1)){
                        Menus.player1.setY(Menus.player1.getY() +Boards.cellSize);
                    }
                }
                case KeyEvent.VK_LEFT -> {
                    if(!wall((Menus.player1.getX()/Boards.cellSize)-1, Menus.player1.getY()/Boards.cellSize)){
                        Menus.player1.setX(Menus.player1.getX() -Boards.cellSize);
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    if(!wall((Menus.player1.getX()/Boards.cellSize)+1, Menus.player1.getY()/Boards.cellSize)){
                        Menus.player1.setX(Menus.player1.getX() +Boards.cellSize);
                    }
                }
                case KeyEvent.VK_SPACE -> {
                    if(b1.getTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize) != "F" && b1.getTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize) != "f"){
                        if(Menus.player1.getFlowers() > 0){
                            Menus.player1.plant();
                            b1.setTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize, "f");
                        }
                    } else if (b1.getTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize) == "f"){
                        Menus.player1.pickUp();
                        b1.setTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize, "n");
                    }
                }
            }
            repaint();
        }
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {
        }
    }

    private class P2KeyListener implements KeyListener {

        public void keyPressed(KeyEvent k) {
            switch(k.getKeyCode()){
                case KeyEvent.VK_W -> {
                    if(!wall(Menus.player2.getX()/Boards.cellSize, (Menus.player2.getY()/Boards.cellSize)-1)){
                        Menus.player2.setY(Menus.player2.getY() -Boards.cellSize);
                    }
                }
                case KeyEvent.VK_S -> {
                    if(!wall(Menus.player2.getX()/Boards.cellSize, (Menus.player2.getY()/Boards.cellSize)+1)){
                        Menus.player2.setY(Menus.player2.getY() +Boards.cellSize);
                    }
                }
                case KeyEvent.VK_A -> {
                    if(!wall((Menus.player2.getX()/Boards.cellSize)-1, Menus.player2.getY()/Boards.cellSize)){
                        Menus.player2.setX(Menus.player2.getX() -Boards.cellSize);
                    }
                }
                case KeyEvent.VK_D -> {
                    if(!wall((Menus.player2.getX()/Boards.cellSize)+1, Menus.player2.getY()/Boards.cellSize)){
                        Menus.player2.setX(Menus.player2.getX() +Boards.cellSize);
                    }
                }
                case KeyEvent.VK_SHIFT -> {
                    if(b1.getTileTable(Menus.player2.getX()/Boards.cellSize, Menus.player2.getY()/Boards.cellSize) != "f" && b1.getTileTable(Menus.player2.getX()/Boards.cellSize, Menus.player2.getY()/Boards.cellSize) != "F"){
                        if(Menus.player2.getFlowers() > 0){
                            Menus.player2.plant();
                            b1.setTileTable(Menus.player2.getX()/Boards.cellSize, Menus.player2.getY()/Boards.cellSize, "F");
                        }
                    }else if (b1.getTileTable(Menus.player2.getX()/Boards.cellSize, Menus.player2.getY()/Boards.cellSize) == "F"){
                        Menus.player2.pickUp();
                        b1.setTileTable(Menus.player2.getX()/Boards.cellSize, Menus.player2.getY()/Boards.cellSize, "n");
                    }
                }
            }
            repaint();
        }
        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public class FlowersLeftPanel extends JPanel{
        Player player;
        public FlowersLeftPanel(Player p){
            player = p;
            setPreferredSize(new Dimension(200, 50));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String flowers = String.valueOf(player.getFlowers()) + " flowers left!";
            g.setFont(new Font(getName(), Font.BOLD, 12));
            g.drawString(flowers,10, 30);
        }
    }

    public boolean wall(int x, int y){
        if(b1.getTileTable(x,y)== "w"){
            return true;
        }
        return false;
    }
}
