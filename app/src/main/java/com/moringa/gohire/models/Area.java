
package com.moringa.gohire.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Area {


    @SerializedName("id")
    @Expose
     Integer id;
    @SerializedName("name")
    @Expose
     String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Area() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public Area(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
