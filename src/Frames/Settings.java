package Frames;
import javax.swing.*;

public class Settings extends JFrame {

    private JButton themeButton;
    private JButton exitButton;

    public Settings() {

        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        //ImageIcon backgroundImage = new ImageIcon("Image/MainMenu.png");
        this.setVisible(true);


        themeButton = new JButton("Přepnout téma");
        themeButton.setBounds(800, 500, 200, 50);
        themeButton.addActionListener(e -> toggleTheme());
        this.add(themeButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(800, 500, 200, 50);
        exitButton.addActionListener(e -> this.dispose());
        this.add(exitButton);
    }

    private boolean isDarkMode = false;
    private void toggleTheme() {
        isDarkMode = !isDarkMode;
        updateTheme();
    }

    public String updateTheme() {
        if (isDarkMode) {
            return "Dark";
        } else {
            return "Light";
        }
    }

}
