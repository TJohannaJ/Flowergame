package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu1 extends Menus {
    private JButton button1;
    private JButton button2;
    public Menu1(){
        super();
        setSize(400,100);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label = new JLabel("Choose one!");
        button1 = new JButton("One player mode");
        button2 = new JButton("Two player mode");

        button2.addActionListener(new TwoPlayerButtonActionListener());
        button1.addActionListener((new OnePlayerButtonActionListener()));

        top.add(label);
        bottom.add(button1);
        bottom.add(button2);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class TwoPlayerButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Menu2_TwoPlayer menu2t = new Menu2_TwoPlayer();
            menu2t.setVisible(true);
            setVisible(false);
        }
    }

    public class OnePlayerButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Menu2_OnePlayer menu2o = new Menu2_OnePlayer();
            menu2o.setVisible(true);
            setVisible(false);
        }
    }
}
