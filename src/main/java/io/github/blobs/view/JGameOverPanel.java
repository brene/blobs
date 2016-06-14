package io.github.blobs.view;

import io.github.blobs.MVC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by root on 08.06.16.
 */
public class JGameOverPanel extends JComponent implements KeyListener {
    private JTextField textField;

    public JGameOverPanel() {
        textField = new JTextField();
        textField.setBounds(350, 340, 470, 120);
        textField.setForeground(new Color(7, 112, 152));
        textField.setBackground(new Color(0, 0, 0, 0));
        textField.setBorder(null);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("PixelSplitter-Bold", Font.BOLD, 57));
        textField.addKeyListener(this);
        this.add(textField);
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream("img" + File.separator + "gameover.png");
            g.drawImage(ImageIO.read(inputStream), 0, 0, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            MVC.getController().submitHighscore(textField.getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
