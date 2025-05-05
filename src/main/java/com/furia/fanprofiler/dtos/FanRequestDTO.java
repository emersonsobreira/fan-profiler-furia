package com.furia.fanprofiler.dtos;

import java.util.List;

public class FanRequestDTO {

    private String name;
    private String cpf;
    private String email;
    private String address;
    private String aiAnalysisResult;
    private String documentPath;

    private List<String> interests;
    private List<String> events;
    private List<String> purchases;
    private List<String> socialLinks;
    private List<String> esportsProfiles;

    private SocialMediaProfileDTO socialMediaProfile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAiAnalysisResult() {
        return aiAnalysisResult;
    }

    public void setAiAnalysisResult(String aiAnalysisResult) {
        this.aiAnalysisResult = aiAnalysisResult;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
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

    public SocialMediaProfileDTO getSocialMediaProfile() {
        return socialMediaProfile;
    }

    public void setSocialMediaProfile(SocialMediaProfileDTO socialMediaProfile) {
        this.socialMediaProfile = socialMediaProfile;
    }

}
