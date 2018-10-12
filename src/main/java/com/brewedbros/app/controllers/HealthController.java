package com.brewedbros.app.controllers;

import com.brewedbros.app.constants.VoucherConstants;
import com.brewedbros.app.services.BannerService;
import com.brewedbros.app.services.VoucherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/{city}")
@Controller
public class HealthController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private BannerService bannerService;
    private static Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping(value = {"/health"})
    public String getEvents(Model model, @PathVariable("city") String city,
                            @RequestParam(value = "area", required = false) String area,
                            @RequestParam(value = "price", required = false) String price,
                            @RequestParam(value = "time", required = false) String time,
                            @RequestParam(value = "sort", required = false) String sort, HttpServletRequest request) throws Exception {

        model.addAttribute("eventList", voucherService.getVoucherByTypeAndCity(VoucherConstants.HEALTH, city));

        model.addAttribute("bannerList", bannerService.getHomepageBanners(city));
        /*model.addAttribute("eventList", voucherService.getEvents(city));*/


        return "events";
    }


    @GetMapping(value = {"/health/{voucherName}"})
    public String getSingleEvents(Model model, @PathVariable("city") String city, @PathVariable("voucherName") String voucherName, HttpServletRequest request) throws Exception {

        model.addAttribute("event", voucherService.getSingleEvents(city, voucherName,VoucherConstants.HEALTH));
        return "event";
    }
}
