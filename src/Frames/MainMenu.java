package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;


    public MainMenu() {
        this.setTitle("Main Menu");
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

        label = new JLabel(backgroundImage);
        label.setBounds(0, 0, 500, 500);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

        }
    }
}
