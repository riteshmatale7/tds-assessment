
package com.tds.assessment.model;


public class Translation {

    public String language;
    public String translation;

    public String getLanguage() {
        return language;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public String toString() {
        return "Translation{" + "language=" + language + ", translation=" + translation + '}';
    }

}
