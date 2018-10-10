package com.mad.quickpick.profile;

public class UserProfile {

    private String user_fname;
    private String user_lname;
    private String user_image_url;
    private String user_about_me;
    private String user_trip_count;


    public UserProfile() {}

    public UserProfile(String user_fname, String user_lname, String user_image_url,
                       String user_about_me, String user_trip_count) {
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_image_url = user_image_url;
        this.user_about_me = user_about_me;
        this.user_trip_count = user_trip_count;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getUser_about_me() {
        return user_about_me;
    }

    public void setUser_about_me(String user_about_me) {
        this.user_about_me = user_about_me;
    }

    public String getUser_trip_count() {
        return user_trip_count;
    }

    public void setUser_trip_count(String user_trip_count) {
        this.user_trip_count = user_trip_count;
    }
}
