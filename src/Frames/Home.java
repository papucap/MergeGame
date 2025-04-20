package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button;
    private JButton button2;


    public Home() {
        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon backgroundImage = new ImageIcon("");

        ImageIcon play = new ImageIcon("");
        button = new JButton("Play");
        button.setBounds(0, 0, 200, 200);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBorderPainted(false);
        this.add(button);

        ImageIcon exit = new ImageIcon("");
        button2 = new JButton("Exit");
        button2.setBounds(200, 200, 200, 200);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setBorderPainted(false);
        this.add(button2);

        label = new JLabel(backgroundImage);
        label.setBounds(0, 0, 500, 500);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            MainMenu mainMenu = new MainMenu();
            this.dispose();
        }
        if (e.getSource() == button2) {
            System.exit(0);
        }
    }


}
