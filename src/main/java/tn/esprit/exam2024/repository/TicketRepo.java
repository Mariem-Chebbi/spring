package tn.esprit.exam2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam2024.entities.Internaute;
import tn.esprit.exam2024.entities.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {

}
