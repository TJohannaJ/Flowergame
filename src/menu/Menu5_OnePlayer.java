package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu5_OnePlayer extends Menus{

    private JButton button;
    public Menu5_OnePlayer(){
        super();
        setSize(400,150);

        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label1 = new JLabel("End of game!");
        JLabel label2 = new JLabel("Your score: " +Menus.player1.getScore());
        button = new JButton("Next");

        button.addActionListener(new NextButtonListener());

        top.add(label1);
        middle.add(label2);
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
