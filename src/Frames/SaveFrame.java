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
    private Settings settings;


    public SaveFrame(Coin coin, Storage storage, Home home, Statistics statistics, Settings settings) {
        this.coin = coin;
        this.storage = storage;
        this.home = home;
        this.statistics = statistics;
        this.settings = settings;

        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1024, 1024);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon("Image/"+settings.updateTheme()+"/Save.png");
        this.setVisible(true);


        button1 = new JButton();
        button1.setBounds(250, 230, 550, 175);
        button1.addActionListener(this);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setFocusable(false);
        button1.setBorderPainted(false);
        this.add(button1);

        button2 = new JButton();
        button2.setBounds(250, 450, 550, 175);
        button2.addActionListener(this);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setBorderPainted(false);
        this.add(button2);

        button3 = new JButton();
        button3.setBounds(250, 670, 550, 175);
        button3.addActionListener(this);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setFocusable(false);
        button3.setBorderPainted(false);
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
            this.dispose();
        }
        if (e.getSource() == button2) {
            SaveManage.saveGame(coin, home.getProductsOnField(), storage.getProducts(),statistics,2);
            JOptionPane.showMessageDialog(this, "Save Complete.");
            this.dispose();
        }
        if (e.getSource() == button3) {
            SaveManage.saveGame(coin, home.getProductsOnField(), storage.getProducts(), statistics,3);
            JOptionPane.showMessageDialog(this, "Save Complete.");
            this.dispose();
        }
        if (e.getSource() == exitButton) {
            this.dispose();
        }
    }
}