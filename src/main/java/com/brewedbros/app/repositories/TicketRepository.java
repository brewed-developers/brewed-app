package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

    List<Ticket> findByVoucherId(String voucherId);
    Optional<Ticket> findById(String id);


}
