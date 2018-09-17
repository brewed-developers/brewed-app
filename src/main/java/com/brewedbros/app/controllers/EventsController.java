package com.brewedbros.app.controllers;

import com.brewedbros.app.constants.VoucherConstants;
import com.brewedbros.app.services.BannerService;
import com.brewedbros.app.services.EventService;
import com.brewedbros.app.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/{city}")
@Controller
public class EventsController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private BannerService bannerService;

    @GetMapping("/events")
    public String getEvents(Model model, @PathVariable("city") String city) throws Exception {
        model.addAttribute("bannerList", bannerService.getHomepageBanners(city));
        model.addAttribute("eventList", voucherService.getAllVouchers());
        /*model.addAttribute("eventList", voucherService.getEvents(city));*/
        return "events";
    }

    @GetMapping("/events/{area}-events")
    public String getEventsByArea(Model model, @PathVariable("city") String city, @PathVariable("area") String area) throws Exception {
        //model.addAttribute("eventList", voucherService.getEventsByCityAndArea(city, area));
        model.addAttribute("eventList", voucherService.getAllVouchers());
        return "events";
    }

    @GetMapping("/events/{eventName}")
    public String getSingleEvents(Model model, @PathVariable("city") String city, @PathVariable("eventName") String eventName) throws Exception {

        model.addAttribute("event", voucherService.getSingleEvents(city, eventName));
        return "event";
    }
}
