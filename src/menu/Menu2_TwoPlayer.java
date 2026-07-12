package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu2_TwoPlayer extends Menus{
    private JTextField name1;
    private JTextField name2;
    private JButton button1;
    public Menu2_TwoPlayer(){
        super();
        setSize(400,150);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel middle = new JPanel();
        JLabel label1 = new JLabel("What's your name?");
        JLabel label2 = new JLabel("Name: ");
        JLabel label3 = new JLabel("Name: ");
        name1 = new JTextField(30);
        name2 = new JTextField(30);
        button1 = new JButton("Next!");

        button1.addActionListener(new NextButtonListener());
        name1.setEditable(true);
        name2.setEditable(true);

        top.add(label1);
        bottom.add(button1);
        middle.add(label2);
        middle.add(name1);
        middle.add(label3);
        middle.add(name2);
        bottom.add(button1);

        add(top, BorderLayout.NORTH);
        add(middle, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }
    public class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(name1.getText().isEmpty() || name2.getText().isEmpty()){
                return;
            } else {
                getPlayer1().setName(name1.getText());
                getPlayer2().setName(name2.getText());
                Menu3 menu3 = new Menu3();
                menu3.setVisible(true);
                setVisible(false);
            }
        }
    }
}
