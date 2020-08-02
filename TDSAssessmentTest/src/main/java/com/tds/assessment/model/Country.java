package com.tds.assessment.model;

import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private ArrayList<String> callingCodes;
    private String capital;
    private ArrayList<String> altSpellings;
    private String region;
    private String subregion;
    private int population;
    private double latitude;
    private double longitude;
    private String demonym;
    private double area;
    private double gini;
    private ArrayList<String> timezones;
    private ArrayList<String> borders;
    private String nativeName;
    private String numericCode;
    private ArrayList<Currency> currencies;
    private ArrayList<Language> languages;
    private ArrayList<Translation> translations;
    private String Flag;
    private ArrayList<RegionalBloc> regionalBlocs;
    private String cioc;

    public String getName() {
        return name;
    }

    public ArrayList<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public ArrayList<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public ArrayList<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDemonym() {
        return demonym;
    }

    public double getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public ArrayList<String> getTimezones() {
        return timezones;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public ArrayList<Translation> getTranslations() {
        return translations;
    }

    public String getFlag() {
        return Flag;
    }

    public ArrayList<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", topLevelDomain=" + topLevelDomain + ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + ", callingCodes=" + callingCodes + ", capital=" + capital + ", altSpellings=" + altSpellings + ", region=" + region + ", subregion=" + subregion + ", population=" + population + ", latitude=" + latitude + ", longitude=" + longitude + ", demonym=" + demonym + ", area=" + area + ", gini=" + gini + ", timezones=" + timezones + ", borders=" + borders + ", nativeName=" + nativeName + ", numericCode=" + numericCode + ", currencies=" + currencies + ", languages=" + languages + ", translations=" + translations + ", Flag=" + Flag + ", regionalBlocs=" + regionalBlocs + ", cioc=" + cioc + '}';
    }

}
