package statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerMatchStatistics implements Serializable {
    private String nickName;
    private long account_id;
    private Integer player_slot;
    private Integer hero_id;
    private List<Integer> hero_inventory = new ArrayList<>();
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer last_hits;
    private Integer denies;
    private Integer GPM;
    private Integer XPM;
    private Integer level;
    private Integer hero_damage;
    private Integer hero_healing;
    private Integer netWorse;
    private List<Integer> goldChange = new ArrayList<>();
    private List<Integer> expChange = new ArrayList<>();
    private List<Integer> backPack = new ArrayList<>();
    private static Boolean matchProcessingFlag = true;

    public long getAccount_id() {
        return account_id;
    }

    public Integer getPlayer_slot() {
        return player_slot;
    }

    public Integer getHero_id() {
        return hero_id;
    }

    public List<Integer> getHero_inventory() {
        return hero_inventory;
    }

    public Integer getKills() {
        return kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getLast_hits() {
        return last_hits;
    }

    public Integer getDenies() {
        return denies;
    }

    public Integer getGPM() {
        return GPM;
    }

    public Integer getXPM() {
        return XPM;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getHero_damage() {
        return hero_damage;
    }

    public Integer getHero_healing() {
        return hero_healing;
    }

    public Integer getNetWorse() {
        return netWorse;
    }

    public List<Integer> getGoldChange() {
        return goldChange;
    }

    public List<Integer> getExpChange() {
        return expChange;
    }

    public static Boolean getMatchProcessingFlag() {
        return matchProcessingFlag;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public void setPlayer_slot(Integer player_slot) {
        this.player_slot = player_slot;
    }

    public void setHero_id(Integer hero_id) {
        this.hero_id = hero_id;
    }

    public void setHero_inventory(List<Integer> hero_inventory) {
        this.hero_inventory = hero_inventory;
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

    public void setLast_hits(Integer last_hits) {
        this.last_hits = last_hits;
    }

    public void setDenies(Integer denies) {
        this.denies = denies;
    }

    public void setGPM(Integer GPM) {
        this.GPM = GPM;
    }

    public void setXPM(Integer XPM) {
        this.XPM = XPM;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setHero_damage(Integer hero_damage) {
        this.hero_damage = hero_damage;
    }

    public void setHero_healing(Integer hero_healing) {
        this.hero_healing = hero_healing;
    }

    public void setNetWorse(Integer netWorse) {
        this.netWorse = netWorse;
    }

    public void setGoldChange(List<Integer> goldChange) {
        this.goldChange = goldChange;
    }

    public void setExpChange(List<Integer> expChange) {
        this.expChange = expChange;
    }

    public static void setMatchProcessingFlag(Boolean matchProcessingFlag) {
        PlayerMatchStatistics.matchProcessingFlag = matchProcessingFlag;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Integer> getBackPack() {
        return backPack;
    }

    public void setBackPack(List<Integer> backpack) {
        this.backPack = backPack;
    }
}