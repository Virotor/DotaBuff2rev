public class Model implements Runnable {
    private PlayerStatistics playerStatistics;
    private String str;
    private boolean wait;
    @Override
    public void run() {
        wait=false;
        PlayerStatistics playerStatistics = Client.playerStatisticsAndMatches(str);
        wait=true;
    }

    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isWait() {
        return wait;
    }
}
