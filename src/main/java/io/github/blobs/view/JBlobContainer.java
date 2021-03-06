package io.github.blobs.view;

import io.github.blobs.MVC;
import io.github.blobs.model.Blob;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public abstract class JBlobContainer extends JLabel {
    private static final String IMG_PATH = "img" + File.separator;
    private Blob blob;

    public JBlobContainer(Blob blob) {
        super("", new ImageIcon(""), JLabel.CENTER);
        showBlob(blob);

        this.addMouseListener(new JBlobMouseListener(this, MVC.getController()));
    }

    public Blob getBlob() {
        return blob;
    }

    public boolean isEmpty() {
        return blob == null;
    }

    public void showBlob(Blob blob) {
        this.blob = blob;
        setVisible(true);
        int random = (int) (Math.random() * 8.0) + 1;
        ClassLoader classLoader = this.getClass().getClassLoader();
        File imgFile = new File(classLoader.getResource(IMG_PATH + "monster" + random + ".png").getFile());
        try {
            setIcon(new ImageIcon(imgFile.toURI().toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void hideBlob() {
        blob = null;
        setVisible(false);
    }
}
