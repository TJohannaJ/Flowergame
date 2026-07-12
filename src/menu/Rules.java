package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends Menus{
    private JButton button1;
    public Rules(){
        super();
        setSize(500,600);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel pic = new JLabel();
        button1 = new JButton("Play!");

        pic.setIcon(new ImageIcon(new ImageIcon("rules.jpg").getImage().getScaledInstance(500,500, Image.SCALE_SMOOTH)));
        button1.addActionListener(new NextButtonListener());

        bottom.add(button1);
        top.add(pic);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }
    public class NextButtonListener implements ActionListener {
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
}
