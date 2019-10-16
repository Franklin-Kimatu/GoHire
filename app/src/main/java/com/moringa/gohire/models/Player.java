
package com.moringa.gohire.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Player {

    @SerializedName("id")
    @Expose
     Integer id;
    @SerializedName("name")
    @Expose
     String name;
    @SerializedName("firstName")
    @Expose
     String firstName;
    @SerializedName("lastName")
    @Expose
     String lastName;
    @SerializedName("dateOfBirth")
    @Expose
     String dateOfBirth;
    @SerializedName("countryOfBirth")
    @Expose
     String countryOfBirth;
    @SerializedName("nationality")
    @Expose
     String nationality;
    @SerializedName("position")
    @Expose
     String position;
    @SerializedName("shirtNumber")
    @Expose
     Integer shirtNumber;
    @SerializedName("lastUpdated")
    @Expose
     String lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Player() {
    }

    /**
     * 
     * @param position
     * @param dateOfBirth
     * @param id
     * @param countryOfBirth
     * @param lastName
     * @param nationality
     * @param shirtNumber
     * @param name
     * @param lastUpdated
     * @param firstName
     */
    public Player(Integer id, String name, String firstName, String lastName, String dateOfBirth, String countryOfBirth, String nationality, String position, Integer shirtNumber, String lastUpdated) {
        super();
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.nationality = nationality;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.lastUpdated = lastUpdated;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",this.id,this.name,this.firstName,this.lastName,this.countryOfBirth,this.nationality,this.position,this.shirtNumber,this.lastUpdated);
    }

}
