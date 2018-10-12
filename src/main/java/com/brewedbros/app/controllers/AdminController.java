package com.brewedbros.app.controllers;


import com.brewedbros.app.entities.Banner;
import com.brewedbros.app.entities.Ticket;
import com.brewedbros.app.entities.Voucher;
import com.brewedbros.app.repositories.TicketRepository;
import com.brewedbros.app.services.AWSS3Service;
import com.brewedbros.app.services.BannerService;
import com.brewedbros.app.services.TicketService;
import com.brewedbros.app.services.VoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    VoucherService voucherService;
    @Autowired
    TicketService ticketService;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private AWSS3Service awss3Service;
    @Autowired
    BannerService bannerService;
    Banner banner=new Banner();
    Voucher voucher=new Voucher();
    @GetMapping("/vouchers")
    public String home(Model model) throws Exception {
        model.addAttribute("voucherList", voucherService.getAllVouchers());
        return "admin/vouchers";
    }


    @GetMapping("/voucher")
    public String add(Model model) throws Exception {
        model.addAttribute("voucher", new Voucher());
        model.addAttribute("ticket", new Ticket());
        return "admin/addVoucher";
    }

    @DeleteMapping("/voucher/{id}")
    public String deleteVoucher(Model model, @PathVariable("id") String id) throws Exception {
        voucherService.deleteVoucher(id);
        model.addAttribute("voucherList", voucherService.getAllVouchers());
        return "admin/addVoucher";
    }

    @PostMapping("/voucher")
    public String SaveVoucher(Model model, @ModelAttribute Voucher voucher) throws Exception {
        if (voucher.getName() != null) {
            System.out.print(voucher.getName());
            voucherService.saveVoucher(voucher);
        }
        return "redirect:vouchers";
    }

    @GetMapping("/voucher/{id}")
    public String getVoucherAndTicket(Model model, @PathVariable("id") String id) throws Exception {
        model.addAttribute("voucher", voucherService.getVoucher(id));
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("ticketList", ticketService.getTicketsbyId(id));
        return "admin/addVoucher";
    }

    @PostMapping("/ticket")
    public String addticket(Model model, Ticket ticket) throws Exception {
        ticketService.addTicket(ticket);
        return home(model);
    }
    @GetMapping("/ticket/{id}")
    ResponseEntity<Object> getUser(@PathVariable("id") String id	 )
    {

        return new ResponseEntity<Object>(ticketRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{id}")
    ResponseEntity<Object> deleteTicket(@PathVariable("id") String id	 )
    {

        return new ResponseEntity<Object>(ticketService.deleteVoucher(id), HttpStatus.OK);
    }
    @GetMapping("/banner")
    public String Uploadbanner(Model model) throws Exception {
        model.addAttribute("banner", new Banner());
        return "admin/addBanner";
    }
    @PostMapping("/uploadVoucherImage")
    ResponseEntity<Object> uploadVoucherImage(@RequestParam("id") String id,@RequestPart(value = "file") MultipartFile file) {

        voucher.setId(id);

        voucher.setImgURL(this.awss3Service.uploadFile(file));

        voucherService.saveVoucherImage(voucher);

        return new ResponseEntity<Object>("File Uploaded Successfully", HttpStatus.OK);
    }
    @PostMapping("/banner")
    public String bannerDetails(Model model, @ModelAttribute Banner banner) throws Exception {
       // banner.setId("1");
        bannerService.saveBanner(banner);
        model.addAttribute("bannerList", bannerService.getAllBanner());
        return "admin/banners";
    }
    @GetMapping("/banners")
    public String addBanner(Model model) throws Exception {
        model.addAttribute("bannerList", bannerService.getAllBanner());
        return "admin/banners";
    }
    @GetMapping("/banner/{id}")
    public String getBanner(Model model, @PathVariable("id") String id) throws Exception {
        model.addAttribute("banner", bannerService.getBanner(id));

        return "admin/addBanner";
    }

    @PostMapping("/uploadBanner")
    ResponseEntity<Object> uploadBanner(@RequestParam("id") String id,@RequestPart(value = "file") MultipartFile file) {

        banner.setId(id);

        banner.setImgUrl(this.awss3Service.uploadFile(file));

       // voucherService.saveVoucherImage(voucher);
        bannerService.uploadBanner(banner);

        return new ResponseEntity<Object>("File Uploaded Successfully", HttpStatus.OK);
    }
    @DeleteMapping("/banner/{id}")
    ResponseEntity<Object> deleteBanner(@PathVariable("id") String id	 )
    {

        return new ResponseEntity<Object>(bannerService.deleteBanner(id), HttpStatus.OK);
    }

}


