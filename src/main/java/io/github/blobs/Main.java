package io.github.blobs;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class
Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.loadFonts();
        MVC.launch();
    }

    private void loadFonts() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream("fonts" + File.separator +
                    "PixelSplitter-Bold.ttf");
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, inputStream));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
