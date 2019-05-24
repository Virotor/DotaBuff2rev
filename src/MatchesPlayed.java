import java.io.Serializable;

public class MatchesPlayed implements Serializable {

    private Long matchID;
    private Integer lobbyType;
    private Boolean radiantWin;
    private Integer duration;
    private Integer heroId;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer playerSlot;


    public Long getMatchID() {
        return matchID;
    }

    public Integer getLobbyType() {
        return lobbyType;
    }

    public Boolean getRadiantWin() {
        return radiantWin;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getKills() {
        return kills;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

    public void setLobbyType(Integer lobbyType) {
        this.lobbyType = lobbyType;
    }

    public void setRadiantWin(Boolean radiantWin) {
        this.radiantWin = radiantWin;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPlayerSlot() {
        return playerSlot;
    }

    public void setPlayerSlot(Integer playerSlot) {
        this.playerSlot = playerSlot;
    }
}
