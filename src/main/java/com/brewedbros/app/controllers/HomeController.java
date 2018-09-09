package com.brewedbros.app.controllers;

import com.brewedbros.app.services.BannerService;
import com.brewedbros.app.services.VoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
@Controller
public class HomeController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/{city}")
    public String home(Model model, @PathVariable("city") String city1) throws  Exception{

        System.out.println("City" + city1);

      // model.addAttribute("voucherList", new ObjectMapper().writeValueAsString(voucherService.getAllVoucherByRating()));

       model.addAttribute("bannerList",bannerService.getHomepageBanners(city1));
       model.addAttribute("voucherList",voucherService.getAllVoucherByRating());
       model.addAttribute("voucherMapByType",voucherService.getAllVoucherByType());
        return "index";
       //return  "minimumcode";
    }
    //tempoeary put in admin controller
    @GetMapping("vouchers")

    public String home(Model model) throws  Exception{


        model.addAttribute("voucherList",voucherService.getAllVouchers());

        //

        return "admin/vouchers";
        //return  "minimumcode";
    }
}