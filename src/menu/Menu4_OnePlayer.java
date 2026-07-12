package menu;

import boards.*;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.String.valueOf;

public class Menu4_OnePlayer extends Menus{
    private Boards_OnePlayer b1;
    public Menu4_OnePlayer(){
        super();
        setSize(704, 580);

        JLabel player1name = new JLabel(getPlayer1().getName());
        JPanel top = new JPanel();
        FlowersLeftPanel flower = new FlowersLeftPanel(player1);
        b1= new Boards_OnePlayer();
        JPanel bottom = b1;

        top.setSize(704,100);
        b1.set_time();

        top.add(flower);
        top.add(player1name);

        addKeyListener(new MyKeyListener());
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private class MyKeyListener implements KeyListener {
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
                    if(b1.getTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize) != "f"){
                        if(Menus.player1.getFlowers() > 0){
                            Menus.player1.plant();
                            b1.setTileTable(Menus.player1.getX()/Boards.cellSize, Menus.player1.getY()/Boards.cellSize, "f");
                        }
                    } else {
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
