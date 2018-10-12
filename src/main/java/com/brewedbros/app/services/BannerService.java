package com.brewedbros.app.services;

import com.brewedbros.app.entities.Banner;
import com.brewedbros.app.repositories.BannerRepository;
import com.brewedbros.app.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brewedbros.app.entities.Voucher;
import java.util.List;
import java.util.Optional;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    VoucherRepository voucherRepository;

    public List<Banner> getHomepageBanners(String city) {
        return bannerRepository.findByCity(city);
    }

    public Banner saveBannerImage(Banner banner)
    {

       Voucher voucher=voucherRepository.findOneById(banner.getVoucherId());
        banner.setCity(voucher.getCity());
        banner.setImgUrl(banner.getImgUrl());
        banner.setTitle(voucher.getTitle());
        banner.setDescription(voucher.getLongDescription());
        banner.setId("1");
        banner.setVoucherId(banner.getVoucherId());
        voucher.setImgURL(banner.getImgUrl());
        voucherRepository.save(voucher);
        bannerRepository.save(banner);

        return null;
    }
}
