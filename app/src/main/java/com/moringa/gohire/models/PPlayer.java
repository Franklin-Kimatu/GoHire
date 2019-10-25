package com.moringa.gohire.models;

public class PPlayer {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PPlayer(String id, String firstName, String commonName, String nationality, String shirtNumber, String position) {
        this.id = id;
        this.firstName = firstName;
        this.commonName = commonName;
        this.nationality = nationality;
        this.shirtNumber = shirtNumber;
        this.position = position;
    }

    private String id;
    private  String firstName;
    private  String commonName;
    private  String nationality;
    private  String shirtNumber;
    private String position;

    public PPlayer() {
    }
}
