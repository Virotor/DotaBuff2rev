package Matches;

public class LastMatches {

    private Long matchID;
    private Integer lobbyType;
    private Boolean radiantWin;
    private Integer duration;
    private Integer heroId;
    private Integer kills;
    private Integer deaths;
    private Integer assists;

    public LastMatches (){
    }

    public LastMatches(Long matchID, Integer lobbyType, Boolean radiantWin, Integer duration, Integer heroId, Integer kills, Integer deaths, Integer assists) {
        this.matchID = matchID;
        this.lobbyType = lobbyType;
        this.radiantWin = radiantWin;
        this.duration = duration;
        this.heroId = heroId;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
    }


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
}
