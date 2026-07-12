package menu;

import player.Game;
import player.LeaderBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu6 extends Menus{
    private JButton button1;
    private JButton button2;
    public Menu6(){
        super();
        setSize(400,100);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label = new JLabel("Do you want to save your score?");

        button1 = new JButton("Yes!");
        button2 = new JButton("No!");
        button2.addActionListener(new NoSaveButtonActionListener());
        button1.addActionListener((new SaveButtonActionListener()));

        top.add(label);
        bottom.add(button1);
        bottom.add(button2);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class NoSaveButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Thanks for playing! I hope you enjoyed the game!");
            System.exit(0);
        }
    }

    public class SaveButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Game game = winnerGet();
            LeaderBoard leaderboard = LeaderBoard.loadFromTextFile("leaderboard.txt");
            leaderboard.addGame(game);
            leaderboard.saveToJsonFileAsText("leaderboard.txt");

            System.exit(0);
        }

        public Game winnerGet(){
            Game winner;
            if(Menus.player1.getScore() > Menus.player2.getScore()){
                winner = new Game (Menus.player1.getName(), Menus.player1.getScore());
            } else if (Menus.player1.getScore() < Menus.player2.getScore()) {
                winner = new Game(Menus.player2.getName(), Menus.player2.getScore());
            } else {
                winner = new Game((Menus.player1.getName() + " & " + Menus.player2.getName()), Menus.player1.getScore());
            }
            return winner;
        }
    }

}
