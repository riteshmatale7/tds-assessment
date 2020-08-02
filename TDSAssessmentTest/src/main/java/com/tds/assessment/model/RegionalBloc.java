
package com.tds.assessment.model;

import java.util.ArrayList;

public class RegionalBloc {

    public String acronym;
    public String name;
    public ArrayList<String> otherAcronyms;
    public ArrayList<String> otherNames;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public ArrayList<String> getOtherNames() {
        return otherNames;
    }

    @Override
    public String toString() {
        return "RegionalBloc{" + "acronym=" + acronym + ", name=" + name + ", otherAcronyms=" + otherAcronyms + ", otherNames=" + otherNames + '}';
    }

}
