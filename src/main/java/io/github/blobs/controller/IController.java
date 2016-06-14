package io.github.blobs.controller;

import io.github.blobs.model.Blob;

public interface IController {

    void killBlob(Blob blob);

    void submitHighscore(String name);

    void startGame();

    void restartGame();
}
