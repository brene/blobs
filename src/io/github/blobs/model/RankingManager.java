package io.github.blobs.model;

import io.github.blobs.Constants;
import io.github.blobs.network.AzureConnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingManager {

    private AzureConnector connector;

    public RankingManager() {
        this.connector = new AzureConnector(Constants.GAME_ID);
    }

    public void addRanking(Ranking ranking) {
        this.connector.putScore(ranking.getName(), ranking.getHighscore());
    }

    public List<Ranking> getRankings() {
        List<Ranking> rankings = new ArrayList<Ranking>();
        String json = this.connector.getScores();
        while (json.contains("\"Name\":")) {

            json = json.substring(json.indexOf("\"Name\":\"") + 8);
            String name = json.substring(0, json.indexOf('\"'));
            json = json.substring(json.indexOf("\"Score\":") + 8);
            int score = Integer.parseInt(json.substring(0, json.indexOf("}")));
            rankings.add(new Ranking(name, score));
        }
        Collections.sort(rankings);
        return rankings.subList(0, 10);
    }
}
