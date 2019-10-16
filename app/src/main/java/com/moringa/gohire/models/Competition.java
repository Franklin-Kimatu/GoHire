
package com.moringa.gohire.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Competition {

    @SerializedName("id")
    @Expose
     Integer id;
    @SerializedName("area")
    @Expose
     Area area;
    @SerializedName("name")
    @Expose
     String name;
    @SerializedName("code")
    @Expose
     String code;
    @SerializedName("plan")
    @Expose
     String plan;
    @SerializedName("lastUpdated")
    @Expose
     String lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Competition() {
    }

    /**
     * 
     * @param id
     * @param area
     * @param plan
     * @param name
     * @param lastUpdated
     * @param code
     */
    public Competition(Integer id, Area area, String name, String code, String plan, String lastUpdated) {
        super();
        this.id = id;
        this.area = area;
        this.name = name;
        this.code = code;
        this.plan = plan;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
