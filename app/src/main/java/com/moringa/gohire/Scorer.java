
package com.moringa.gohire;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scorer {

    @SerializedName("player")
    @Expose
    private Player player;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("numberOfGoals")
    @Expose
    private Integer numberOfGoals;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Scorer() {
    }

    /**
     * 
     * @param numberOfGoals
     * @param player
     * @param team
     */
    public Scorer(Player player, Team team, Integer numberOfGoals) {
        super();
        this.player = player;
        this.team = team;
        this.numberOfGoals = numberOfGoals;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(Integer numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

}
