package com.furia.fanprofiler.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furia.fanprofiler.dtos.FanRequestDTO;
import com.furia.fanprofiler.models.Fan;
import com.furia.fanprofiler.models.SocialMediaProfile;
import com.furia.fanprofiler.repositories.FanRepository;
import com.furia.fanprofiler.repositories.SocialMediaProfileRepository;

@Service
public class FanService {

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private SocialMediaProfileRepository socialMediaProfileRepository;

    public Fan createFan(FanRequestDTO dto) {
        // aq criei o objeto Fan
        Fan fan = new Fan();
        fan.setName(dto.getName());
        fan.setCpf(dto.getCpf());
        fan.setEmail(dto.getEmail());
        fan.setAddress(dto.getAddress());
        fan.setAiAnalysisResult(dto.getAiAnalysisResult());
        fan.setDocumentPath(dto.getDocumentPath());
        fan.setInterests(dto.getInterests());
        fan.setEvents(dto.getEvents());
        fan.setPurchases(dto.getPurchases());
        fan.setSocialLinks(dto.getSocialLinks());
        fan.setEsportsProfiles(dto.getEsportsProfiles());

        if (dto.getSocialMediaProfile() != null) {
            SocialMediaProfile smp = new SocialMediaProfile();
            smp.setFacebook(dto.getSocialMediaProfile().getFacebook());
            smp.setInstagram(dto.getSocialMediaProfile().getInstagram());
            smp.setTwitter(dto.getSocialMediaProfile().getTwitter());

            SocialMediaProfile savedProfile = socialMediaProfileRepository.save(smp);

            fan.setSocialMediaProfile(savedProfile);
        }

        return fanRepository.save(fan);
    }

    public Optional<Fan> findById(UUID id) {
        return fanRepository.findById(id);
    }

    public List<Fan> getAllFans() {
        return fanRepository.findAll();
    }

    public Fan updateFan(UUID id, FanRequestDTO dto) {
        Fan fan = findById(id).orElseThrow(() -> new RuntimeException("Fan not found"));
        fan.setName(dto.getName());
        fan.setCpf(dto.getCpf());
        fan.setEmail(dto.getEmail());
        fan.setAddress(dto.getAddress());
        fan.setAiAnalysisResult(dto.getAiAnalysisResult());
        fan.setDocumentPath(dto.getDocumentPath());
        fan.setInterests(dto.getInterests());
        fan.setEvents(dto.getEvents());
        fan.setPurchases(dto.getPurchases());
        fan.setSocialLinks(dto.getSocialLinks());
        fan.setEsportsProfiles(dto.getEsportsProfiles());

        if (dto.getSocialMediaProfile() != null) {
            SocialMediaProfile smp = new SocialMediaProfile();
            smp.setFacebook(dto.getSocialMediaProfile().getFacebook());
            smp.setInstagram(dto.getSocialMediaProfile().getInstagram());
            smp.setTwitter(dto.getSocialMediaProfile().getTwitter());

            SocialMediaProfile savedProfile = socialMediaProfileRepository.save(smp);

            fan.setSocialMediaProfile(savedProfile);
        }

        return fanRepository.save(fan);
    }

    public void deleteFan(UUID id) {
        fanRepository.deleteById(id);
    }
}
