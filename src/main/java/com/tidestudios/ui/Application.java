package com.tidestudios.ui;

import com.formdev.flatlaf.*;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public void beginGUI() {

        FlatDarkLaf.setup();  //Must be called first of all Swing code as this sets the look and feel to FlatDark.
        final JPanel panel = new JPanel(); //FlowLayout.
        panel.setSize(500,500);
        final JFrame frame = new JFrame("TideScript");
        UIManager.put("ToggleButton.arc",999);
        JToggleButton jToggleButton = new JToggleButton();
        jToggleButton.setBackground(new Color(255,0,0));

        panel.add(jToggleButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
