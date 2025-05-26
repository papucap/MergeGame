package Frames;

import Product.Statistics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsFrame extends JFrame implements ActionListener {
    private Statistics statistics;

    private JLabel label;
    private JLabel spendCoins;
    private JLabel merges;
    private JLabel maxLevel;
    private JButton resetButton;
    private JButton exitButton;

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

        Font textFont = new Font("Arial", Font.BOLD,48);

        spendCoins = new JLabel(String.valueOf(statistics.getSpendCoins()));
        spendCoins.setBounds(100,200,200,50);
        spendCoins.setFont(textFont);
        spendCoins.revalidate();
        spendCoins.repaint();
        this.add(spendCoins);

        merges = new JLabel(String.valueOf(statistics.getMerges()));
        merges.setFont(textFont);
        merges.setBounds(100,500,200,50);
        merges.revalidate();
        merges.repaint();
        this.add(merges);

        maxLevel = new JLabel(String.valueOf(statistics.getMaxLevel()));
        maxLevel.setFont(textFont);
        maxLevel.setBounds(100,800,200,50);
        maxLevel.revalidate();
        maxLevel.repaint();
        this.add(maxLevel);

        resetButton = new JButton("Reset");
        resetButton.setBounds(500,500,200,50);
        resetButton.addActionListener(this);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(0, 850, 248, 183);
        exitButton.addActionListener(this);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        this.add(exitButton);

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
            updateLabel();
        }
        if (e.getSource() == exitButton) {
            this.dispose();
        }
    }

    private void updateLabel(){
        maxLevel.setText(String.valueOf(statistics.getMaxLevel()));
        spendCoins.setText(String.valueOf(statistics.getSpendCoins()));
        merges.setText(String.valueOf(statistics.getMerges()));
    }
}
