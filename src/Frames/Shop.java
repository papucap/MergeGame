package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button;
    private JButton button2;


    public Shop() {
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon backgroundImage = new ImageIcon("");

        ImageIcon play = new ImageIcon("");
        button = new JButton("BUY");
        button.setBounds(0, 400, 100, 100);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBorderPainted(false);
        this.add(button);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        button2 = new JButton(exit);
        button2.setBounds(400, 400, 248, 183);
        button2.addActionListener(this);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setBorderPainted(false);
        this.add(button2);

        label = new JLabel(backgroundImage);
        label.setBounds(0, 0, 600, 600);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

        }
        if (e.getSource() == button2) {
            this.dispose();
        }
    }


}
