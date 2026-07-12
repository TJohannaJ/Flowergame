package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu5_TwoPlayer extends Menus{

    private JButton button;
    public Menu5_TwoPlayer(){
        super();
        setSize(400,150);

        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bottom = new JPanel();
        JLabel winner;
        JLabel label1 = new JLabel(Menus.player1.getName() + "'s score: " +Menus.player1.getScore());
        JLabel label2 = new JLabel(Menus.player2.getName() + "'s score: " +Menus.player2.getScore());
        button = new JButton("Next!");

        if(Menus.player1.getScore() == Menus.player2.getScore()) {
            winner = new JLabel("This is a tie!");
        } else if(Menus.player1.getScore() > Menus.player2.getScore()){
            winner = new JLabel("The winner is: " + Menus.player1.getName());
        } else {
            winner = new JLabel("The winner is: " + Menus.player2.getName());
        }
        button.addActionListener(new NextButtonListener());

        top.add(winner);
        left.add(label1);
        right.add(label2);

        middle.add(left, BorderLayout.WEST);
        middle.add(right, BorderLayout.NORTH);
        bottom.add(button);

        add(top, BorderLayout.NORTH);
        add(middle, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Menu6 menu6 = new Menu6();
            menu6.setVisible(true);
            setVisible(false);
        }
    }
}
