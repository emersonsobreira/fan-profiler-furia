package com.furia.fanprofiler.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Fan {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String address;

    @Column
    private String instagram;

    @Column 
    private String twitter;

    @Column
    private String twitch;

    @Lob
    private String aiAnalysisResult;

    private String documentPath;

  
    @ElementCollection
    private List<String> interests;

    @ElementCollection
    private List<String> events;

    @ElementCollection
    private List<String> purchases;

    @ElementCollection
    private List<String> socialLinks;

    @ElementCollection
    private List<String> esportsProfiles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
}
