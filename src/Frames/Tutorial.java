package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame {

    private JLabel label1;
    private JButton themeButton;
    private JButton button2;
    private JButton exitButton;
    private Settings settings;

    public Tutorial(Settings settings) {
        this.settings = settings;

        this.setTitle("Tutorial");
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage1 = new ImageIcon("Image/"+settings.updateTheme()+"/Tutorial.png");
        ImageIcon backgroundImage2 = new ImageIcon("Image/"+settings.updateTheme()+"/Tutorial2.png");
        ImageIcon exitImage = new ImageIcon("Image/Exit.png");
        this.setVisible(true);


        themeButton = new JButton("Přepnout téma");
        themeButton.setBounds(35, 850, 100, 100);
        themeButton.setOpaque(false);
        themeButton.setContentAreaFilled(false);
        themeButton.setFocusable(false);
        themeButton.setBorderPainted(false);
        this.add(themeButton);

        button2 = new JButton("Přepnout téma");
        button2.setBounds(900, 870, 100, 100);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setBorderPainted(false);
        this.add(button2);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(0, 0, 248, 183);
        exitButton.addActionListener(e -> this.dispose());
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        this.add(exitButton);


        label1 = new JLabel(backgroundImage1);
        label1.setSize(1000, 1000);
        this.add(label1);

        themeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setIcon(backgroundImage2);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setIcon(backgroundImage1);
            }
        });
    }
}
