package com.furia.fanprofiler.dtos;

import java.util.List;

public class SocialMediaProfile {

    private String instagram;
    private String twitter;
    private String twitch;
    private List<String> interests;
    private List<String> events;
    private List<String> purchases;
    private List<String> socialLinks;
    private List<String> esportsProfiles;

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitch() {
        return twitch;
    }

    public void setTwitch(String twitch) {
        this.twitch = twitch;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<String> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<String> purchases) {
        this.purchases = purchases;
    }

    public List<String> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<String> socialLinks) {
        this.socialLinks = socialLinks;
    }

    public List<String> getEsportsProfiles() {
        return esportsProfiles;
    }

    public void setEsportsProfiles(List<String> esportsProfiles) {
        this.esportsProfiles = esportsProfiles;
    }
}
