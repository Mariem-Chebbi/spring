package tn.esprit.exam2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam2024.entities.Internaute;
import tn.esprit.exam2024.entities.TrancheAge;

import java.time.LocalDate;

@Repository
public interface InternauteRepo extends JpaRepository<Internaute,Long> {
    Long countByTrancheAgeAndTicketsEvenementDateEvenementBetween(TrancheAge trancheAge, LocalDate d1, LocalDate d2);
}
