
package com.moringa.gohire.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//import org.parceler.Parcel;


import android.os.Parcelable;

import org.parceler.Parcel;

@Parcel
public class Season {

    @SerializedName("id")
    @Expose
     Integer id;
    @SerializedName("startDate")
    @Expose
     String startDate;
    @SerializedName("endDate")
    @Expose
     String endDate;
    @SerializedName("currentMatchday")
    @Expose
     Integer currentMatchday;
    @SerializedName("winner")
    @Expose
     String winner;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Season() {
    }

    /**
     * 
     * @param id
     * @param startDate
     * @param currentMatchday
     * @param winner
     * @param endDate
     */
    public Season(Integer id, String startDate, String endDate, Integer currentMatchday, String winner) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentMatchday = currentMatchday;
        this.winner = winner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(Integer currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public Object getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}
