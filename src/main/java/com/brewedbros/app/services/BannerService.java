package com.brewedbros.app.services;

import com.brewedbros.app.entities.Banner;
import com.brewedbros.app.repositories.BannerRepository;
import com.brewedbros.app.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    VoucherRepository voucherRepository;

    public List<Banner> getHomepageBanners(String city) {
        return bannerRepository.findByCity(city);
    }

    public Banner saveBanner(Banner banner) {

        if (banner.getId() != null && banner.getId() != "") {
            return bannerRepository.save(banner);

        } else {
            banner.setId(UUID.randomUUID().toString());
            return bannerRepository.save(banner);

        }
    }

    public Iterable<Banner> getAllBanner(){return bannerRepository.findAll();}

    public Banner getBanner(String id) { return bannerRepository.findById(id).get(); }

    public Banner uploadBanner(Banner banner)
    {
       Banner bannerDB= bannerRepository.findOneById(banner.getId());
       bannerDB.setImgUrl(banner.getImgUrl());

        return bannerRepository.save(bannerDB);
    }


   public boolean  deleteBanner(String id){  if(id!=null && id!="") bannerRepository.deleteById(id); return true ;}



}
