package com.airportsolutions.airportcrudservice.entity;

import lombok.Generated;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "airports")
public class Airport {
    // Getters and Setters
    @Getter


    @Id
    private String airportCode;
    private String airportName;
    private String id;
    private String city;
    private String country;
    private String countryCode;
    private String dstIndicator;
    private String latitude;
    private String longitude;
    private String region;
    private String timezone;
    private String outbound;
    private String tzregion;
    private boolean listingDisplay;
    private String pseudonyms;
    private String status; // ACTIVE / DEACTIVE


    public void setId(String id) {
        this.id = id;
    }
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
    public String getAirportCode() {
        return airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDstIndicator() {
        return dstIndicator;
    }

    public void setDstIndicator(String dstIndicator) {
        this.dstIndicator = dstIndicator;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getOutbound() {
        return outbound;
    }

    public void setOutbound(String outbound) {
        this.outbound = outbound;
    }

    public String getTzregion() {
        return tzregion;
    }

    public void setTzregion(String tzregion) {
        this.tzregion = tzregion;
    }

    public boolean getListingDisplay() {
        return listingDisplay;
    }

    public void setListingDisplay(boolean listingDisplay) {
        this.listingDisplay = listingDisplay;
    }

    public String getPseudonyms() {
        return pseudonyms;
    }

    public void setPseudonyms(String pseudonyms) {
        this.pseudonyms = pseudonyms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

