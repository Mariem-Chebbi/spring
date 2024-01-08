package tn.esprit.exam2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.exam2024.entities.Evenement;
import tn.esprit.exam2024.entities.TypeTicket;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Evenement, Long> {

    List<Evenement> findByCategoriesIdCategorie(Long id);

    @Query("SELECT sum(t.prixTicket) FROM Evenement e JOIN e.tickets t WHERE t.typeTicket =?2 AND e.nomEvenement =?1"
            )
    Double montantRecupereParEvt(String nomEv, TypeTicket typeTicket);
}
