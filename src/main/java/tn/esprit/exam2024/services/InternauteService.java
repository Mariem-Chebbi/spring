package tn.esprit.exam2024.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.exam2024.entities.Internaute;
import tn.esprit.exam2024.entities.TrancheAge;
import tn.esprit.exam2024.repository.CategorieRepo;
import tn.esprit.exam2024.repository.InternauteRepo;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class InternauteService {
    private InternauteRepo internauteRepo;

    public Internaute ajouterInternaute(Internaute internaute){
        return internauteRepo.save(internaute);
    }

    public Long nbInternaute(TrancheAge trancheAge, LocalDate d1,LocalDate d2){
        return internauteRepo.countByTrancheAgeAndTicketsEvenementDateEvenementBetween(trancheAge,d1,d2);
    }
}
