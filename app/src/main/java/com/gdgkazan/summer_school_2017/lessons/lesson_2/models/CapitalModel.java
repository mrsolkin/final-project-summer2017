package com.gdgkazan.summer_school_2017.lessons.lesson_2.models;

/**
 * @author Timur Valiev
 */
public class CapitalModel {

    private String cityName;

    private String countryName;

    public CapitalModel(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
