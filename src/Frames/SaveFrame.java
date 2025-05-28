package Frames;

import Product.Coin;
import Product.SaveManage;
import Product.Statistics;
import Product.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFrame extends JFrame implements ActionListener {



    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton exitButton;
    private JLabel label;
    private Coin coin;
    private Statistics statistics;
    private Home home;
    private Storage storage;


    public SaveFrame(Coin coin, Storage storage, Home home, Statistics statistics) {
        this.coin = coin;
        this.storage = storage;
        this.home = home;
        this.statistics = statistics;

        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1024, 1024);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon("Image/Settings.png");
        this.setVisible(true);


        button1 = new JButton();
        button1.setBounds(200, 550, 200, 50);
        button1.addActionListener(this);
        this.add(button1);

        button2 = new JButton();
        button2.setBounds(200, 300, 200, 50);
        button2.addActionListener(this);
        this.add(button2);

        button3 = new JButton();
        button3.setBounds(200, 800, 200, 50);
        button3.addActionListener(this);
        this.add(button3);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(0, 850, 248, 183);
        exitButton.addActionListener(this);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        this.add(exitButton);

        label = new JLabel(backgroundImage);
        label.setSize(1024, 1024);
        this.add(label);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            SaveManage.saveGame(coin, home.getProductsOnField(), storage.getProducts(),statistics,1);
            JOptionPane.showMessageDialog(this, "Save Complete.");
        }
        if (e.getSource() == button2) {
            SaveManage.saveGame(coin, home.getProductsOnField(), storage.getProducts(),statistics,2);
            JOptionPane.showMessageDialog(this, "Save Complete.");
        }
        if (e.getSource() == button3) {
            SaveManage.saveGame(coin, home.getProductsOnField(), storage.getProducts(), statistics,3);
            JOptionPane.showMessageDialog(this, "Save Complete.");
        }
        if (e.getSource() == exitButton) {
            this.dispose();
        }
    }
}