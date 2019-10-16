
package com.moringa.gohire.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ScorersResponse {

    @SerializedName("count")
    @Expose
     Integer count;
    @SerializedName("filters")
    @Expose
     Filters filters;
    @SerializedName("competition")
    @Expose
     Competition competition;
    @SerializedName("season")
    @Expose
     Season season;
    @SerializedName("scorers")
    @Expose
     List<Scorer> scorers = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScorersResponse() {
    }

    /**
     * 
     * @param season
     * @param count
     * @param scorers
     * @param filters
     * @param competition
     */
    public ScorersResponse(Integer count, Filters filters, Competition competition, Season season, List<Scorer> scorers) {
        super();
        this.count = count;
        this.filters = filters;
        this.competition = competition;
        this.season = season;
        this.scorers = scorers;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Scorer> getScorers() {
        return scorers;
    }

    public void setScorers(List<Scorer> scorers) {
        this.scorers = scorers;
    }

}
