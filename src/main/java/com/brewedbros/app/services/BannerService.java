package com.brewedbros.app.services;

import com.brewedbros.app.entities.Banner;
import com.brewedbros.app.repositories.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;

    public List<Banner> getHomepageBanners(String city) {
        return bannerRepository.findByCity(city);
    }
}
