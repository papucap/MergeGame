package Frames;

import Product.Statistics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsFrame extends JFrame implements ActionListener {
    private Statistics statistics;

    private JLabel label;
    private JLabel spendCoins;
    private JLabel merges;
    private JLabel maxLevel;
    private JButton resetButton;

    public StatsFrame(Statistics statistics) {
        this.statistics = statistics;

        this.setTitle("Stats");
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon("Image/MainMenu.png");
        this.setVisible(true);

        spendCoins = new JLabel(String.valueOf(statistics.getSpendCoins()));
        spendCoins.setBounds(100,200,200,50);
        this.add(spendCoins);

        merges = new JLabel(String.valueOf(statistics.getMerges()));
        merges.setBounds(100,500,200,50);
        this.add(merges);

        maxLevel = new JLabel(String.valueOf(statistics.getMaxLevel()));
        maxLevel.setBounds(100,800,200,50);
        this.add(maxLevel);

        resetButton = new JButton("Reset");
        resetButton.setBounds(500,500,200,50);
        resetButton.addActionListener(this);

        this.add(resetButton);

        label = new JLabel(backgroundImage);
        label.setSize(1000,1000);
        this.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            statistics.setMaxLevel(0);
            statistics.setSpendCoins(0);
            statistics.setMerges(0);
        }
    }
}
