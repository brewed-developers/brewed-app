package com.brewedbros.app.services;


import com.brewedbros.app.entities.Ticket;
import com.brewedbros.app.entities.Voucher;
import com.brewedbros.app.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getTicketsbyId(String voucherid) {
        return ticketRepository.findByVoucherId(voucherid);
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


}
