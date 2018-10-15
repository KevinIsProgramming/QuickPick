package com.mad.quickpick.trippreferences;

public class TripPreferences {

    private String pref_location;
    private String pref_distance_from_location;
    private String pref_budget;
    private String pref_activity_type;

    public TripPreferences(String pref_location, String pref_distance_from_location, String pref_budget, String pref_activity_type) {
        this.pref_location = pref_location;
        this.pref_distance_from_location = pref_distance_from_location;
        this.pref_budget = pref_budget;
        this.pref_activity_type = pref_activity_type;
    }

    public String getPref_location() {
        return pref_location;
    }

    public void setPref_location(String pref_location) {
        this.pref_location = pref_location;
    }

    public String getPref_distance_from_location() {
        return pref_distance_from_location;
    }

    public void setPref_distance_from_location(String pref_distance_from_location) {
        this.pref_distance_from_location = pref_distance_from_location;
    }

    public String getPref_budget() {
        return pref_budget;
    }

    public void setPref_budget(String pref_budget) {
        this.pref_budget = pref_budget;
    }

    public String getPref_activity_type() {
        return pref_activity_type;
    }

    public void setPref_activity_type(String pref_activity_type) {
        this.pref_activity_type = pref_activity_type;
    }
}
