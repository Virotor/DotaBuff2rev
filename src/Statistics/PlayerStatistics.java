package Statistics;

import java.io.Serializable;

public class PlayerStatistics implements Serializable {
    private String nickName;
    private Double win;
    private Double lose;
    private Double GPM;
    private Double XPM;
    private Double winrate;

    public PlayerStatistics(String name, Double win, Double lose, Double GPM, Double XPM, Double winrate) {
        this.XPM = XPM;
        this.GPM = GPM;
        this.winrate = winrate;
        this.lose = lose;
        this.nickName = name;
        this.win = win;
    }

    public String toString() {
        return this.nickName + "       " + this.win.toString() + "/" + this.lose.toString() + "     " + this.winrate.toString() + "\n" + this.GPM.toString() + "    " + this.XPM.toString();
    }
}