package statistics;

import java.io.Serializable;

public class PlayerStatistics implements Serializable {
    private String nickName;
    private Double win;
    private Double lose;
    private Double winrate;
    private MatchesPlayed[] matchesPlayeds;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getWin() {
        return win;
    }

    public void setWin(Double win) {
        this.win = win;
    }

    public Double getLose() {
        return lose;
    }

    public void setLose(Double lose) {
        this.lose = lose;
    }


    public Double getWinrate() {
        return winrate;
    }

    public void setWinrate(Double winrate) {
        this.winrate = winrate;
    }

    public MatchesPlayed[] getMatchesPlayeds() {
        return matchesPlayeds;
    }

    public void setMatchesPlayeds(MatchesPlayed[] matchesPlayeds) {
        this.matchesPlayeds = matchesPlayeds;
    }
}