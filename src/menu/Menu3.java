package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu3 extends Menus{
    private JButton button1;
    private JButton button2;
    public Menu3(){
        super();
        setSize(400,100);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label = new JLabel("Do you know the rules?");
        button1 = new JButton("Yes!");
        button2 = new JButton("No!");

        button2.addActionListener(new NoButtonActionListener());
        button1.addActionListener((new YesButtonActionListener()));

        top.add(label);
        bottom.add(button1);
        bottom.add(button2);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }

    public class YesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(getPlayer2().getName().equals("")) {
                Menu4_OnePlayer menu4o = new Menu4_OnePlayer();
                menu4o.setVisible(true);
            } else {
                Menu4_TwoPlayer menu4t = new Menu4_TwoPlayer();
                menu4t.setVisible(true);
            }
            setVisible(false);
        }
    }

    public class NoButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Rules rules = new Rules();
            rules.setVisible(true);
            setVisible(false);
        }
    }
}
