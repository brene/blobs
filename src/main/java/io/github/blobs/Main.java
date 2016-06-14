package io.github.blobs;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class
Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.loadFonts();
        MVC.launch();
    }

    private void loadFonts() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts" + File.separator +
                    "PixelSplitter-Bold.ttf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
