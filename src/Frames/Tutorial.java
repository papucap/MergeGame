package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame {

    private JLabel label1;
    private JButton themeButton;
    private JButton exitButton;

    public Tutorial() {
        this.setTitle("Tutorial");
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon("Image/MainMenu.png");
        ImageIcon exitImage = new ImageIcon("Image/Exit.png");
        this.setVisible(true);


        themeButton = new JButton("Přepnout téma");
        themeButton.setBounds(800, 500, 200, 50);
        this.add(themeButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(300, 500, 200, 50);
        exitButton.addActionListener(e -> this.dispose());
        this.add(exitButton);

        label1 = new JLabel(backgroundImage);
        label1.setSize(1000, 1000);
        this.add(label1);

        themeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon newIcon = new ImageIcon("Image/Exit.png");
                label1.setIcon(newIcon);
            }
        });
    }
}
