package io.github.blobs.view;

import io.github.blobs.controller.IController;
import io.github.blobs.model.Blob;
import io.github.blobs.model.Ranking;
import io.github.blobs.util.AudioPlayer;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class View extends JFrame implements IView {
    private JGamePanel gamePanel;
    private JStartPanel startPanel;
    private IController controller;
    private JGameOverPanel gameOverPanel;
    private JHighScorePanel highScorePanel;

    public View() {
        this.setSize(900, 700);
        this.setResizable(false);

        // Create and set up grid
        startPanel = new JStartPanel();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(44, 165, 124));
        setBackground(new Color(44, 165, 124));
        add(startPanel);

        this.setVisible(true);
    }

    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }

    @Override
    public void showSlot(Blob blob) {
        this.gamePanel.getGrid().showSlot(blob);
    }

    @Override
    public void hideSlot(Blob blob) {
        this.gamePanel.getGrid().hideSlot(blob);
    }

    @Override
    public void updateScore(int score) {
        this.gamePanel.updateScore(score);
    }

    @Override
    public void gameOver() {
        gameOverPanel = new JGameOverPanel();
        this.remove(this.gamePanel);
        gameOverPanel.setBounds(0, 0, 900, 700);
        this.gamePanel = null;
        this.add(gameOverPanel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void gameStarted(Blob[] blobs) {
        this.gamePanel = new JGamePanel();
        remove(this.startPanel);
        add(this.gamePanel);
        this.gamePanel.initUI(blobs);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void run() {
        startPanel.startAnimation();
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.playSound("audio" + File.separator + "theme.mp3", MediaPlayer.INDEFINITE);
    }

    @Override
    public void showLeaderboards(List<Ranking> leaderboard) {
        highScorePanel = new JHighScorePanel();
        highScorePanel.initTable(leaderboard);
        this.remove(this.gameOverPanel);
        highScorePanel.setBounds(0, 0, 900, 700);
        this.gameOverPanel = null;
        this.add(highScorePanel);
        this.revalidate();
        this.repaint();

    }
}
