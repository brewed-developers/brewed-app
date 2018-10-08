package com.brewedbros.app.controllers;

import com.brewedbros.app.services.BannerService;
import com.brewedbros.app.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/{city}")
@Controller
public class EventController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private BannerService bannerService;


    @GetMapping("/events")
    public String getEvents(Model model, @PathVariable("city") String city,
                            @RequestParam(value = "area", required = false) String area,
                            @RequestParam(value = "price", required = false) String price,
                            @RequestParam(value = "time", required = false) String time,
                            @RequestParam(value = "sort", required = false) String sort) throws Exception {
        model.addAttribute("bannerList", bannerService.getHomepageBanners(city));
        model.addAttribute("eventList", voucherService.getVoucherByTypeAndCity("event", city));
        /*model.addAttribute("eventList", voucherService.getEvents(city));*/
        return "events";
    }


    @GetMapping("/events/{eventName}")
    public String getSingleEvents(Model model, @PathVariable("city") String city, @PathVariable("eventName") String eventName) throws Exception {

        model.addAttribute("event", voucherService.getSingleEvents(city, eventName));
        return "event";
    }
}
