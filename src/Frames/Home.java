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
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon backgroundImage = new ImageIcon("");

        ImageIcon shop = new ImageIcon("Image/Shop.png");
        button = new JButton(shop);
        button.setBounds(960, 850, 314, 315);
        button.addActionListener(this);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorderPainted(false);
        this.add(button);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        button2 = new JButton(exit);
        button2.setBounds(0, 850, 248, 183);
        button2.addActionListener(this);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setBorderPainted(false);
        this.add(button2);

        label = new JLabel(backgroundImage);
        label.setBounds(0, 0, 1920, 1080);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Shop game = new Shop();
        }
        if (e.getSource() == button2) {
            MainMenu mainMenu = new MainMenu();
            this.dispose();
        }
    }


}
