package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.Ticket;
import com.brewedbros.app.entities.Voucher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

    List<Ticket> findByVoucherId(String voucherId);

}
