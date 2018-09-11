package com.brewedbros.app.controllers;


import com.brewedbros.app.entities.Ticket;
import com.brewedbros.app.entities.Voucher;
import com.brewedbros.app.services.TicketService;
import com.brewedbros.app.services.VoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    VoucherService voucherService;
    @Autowired
    TicketService ticketService;

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

    @DeleteMapping("/voucher")
    public String deleteVoucher(Model model, @PathVariable("id") String id) throws Exception {
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
    public String getVoucherAndTicket(Model model, @RequestParam("id") String id) throws Exception {
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

}
