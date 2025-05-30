package Frames;

import Product.Coin;
import Product.Statistics;
import Product.Storage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

// MainMenu class represents the main menu of the application

public class MainMenu extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;
    private JButton button2;


    private Coin coin;

    private Statistics statistics;

    public MainMenu(Coin coin) {
        this.repaint();
        this.revalidate();
        this.coin = coin;
        this.statistics = new Statistics();
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Image/MainMenu.png"));
        this.setVisible(true);


        button = new JButton("");
        button.setBounds(745, 420, 350, 120);
        button.addActionListener(this);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorderPainted(false);
        this.add(button);

        ImageIcon exit = new ImageIcon(getClass().getResource("/Image/Exit.png"));
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
        // Start game or exit based on button clicked
        if (e.getSource() == button) {
            Home home = new Home(coin,new Settings(coin,statistics,new Storage()),statistics);
            this.dispose();
        }
        if (e.getSource() == button2) {
            System.exit(0);
        }
    }
}
