package io.github.blobs.controller;

import io.github.blobs.model.Blob;
import io.github.blobs.model.IModel;

public class Controller implements IController {

    private IModel model;

    public Controller(IModel model) {
        this.model = model;
    }

    @Override
    public void killBlob(Blob blob) {
        this.model.killBlob(blob);
    }

    @Override
    public void submitHighscore(String name) {
        this.model.submitHighscore(name);
    }

    @Override
    public void startGame() {
        this.model.startGame();
    }

    @Override
    public void restartGame() {
        this.model.restartGame();
    }


}
