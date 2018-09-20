package com.brewedbros.app.services;


import com.brewedbros.app.entities.Ticket;
import com.brewedbros.app.entities.Voucher;
import com.brewedbros.app.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getTicketsbyId(String voucherid) {
        return ticketRepository.findByVoucherId(voucherid);
    }

    public Ticket addTicket(Ticket ticket) {
        if(ticket.getId()!=null && ticket.getId()!="" ){return ticketRepository.save(ticket);}

        else{ticket.setId(UUID.randomUUID().toString());return ticketRepository.save(ticket);}

    }

    public boolean deleteVoucher(String id) {
        if (id != null) {
            ticketRepository.deleteById(id);

        }
     return  true;
    }
}
