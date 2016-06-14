package io.github.blobs.view;

import io.github.blobs.controller.IController;
import io.github.blobs.model.Blob;
import io.github.blobs.model.Ranking;

import java.util.List;

public interface IView {

    void setController(IController controller);

    void showSlot(Blob blob);

    void hideSlot(Blob blob);

    void updateScore(int score);

    void gameOver();

    void gameStarted(Blob[] blobs);

    void run();

    void showLeaderboards(List<Ranking> leaderboard);
}
