package tn.esprit.exam2024.services;

import jdk.jfr.Event;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.exam2024.entities.Categorie;
import tn.esprit.exam2024.entities.Evenement;
import tn.esprit.exam2024.entities.TypeTicket;
import tn.esprit.exam2024.repository.CategorieRepo;
import tn.esprit.exam2024.repository.EventRepo;

@Service
@AllArgsConstructor
@Slf4j
public class EventService {
    private EventRepo eventRepo;
    private CategorieRepo categorieRepo;


    public Evenement ajouterEvenement( Evenement evenement){
        categorieRepo.saveAll(evenement.getCategories());
        return eventRepo.save(evenement);
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void listeEvenementParCategorie(){
        for (Categorie cat: categorieRepo.findAll()){
            log.info(cat.getNomCategorie());
            for (Evenement e : eventRepo.findByCategoriesIdCategorie(cat.getIdCategorie())){
                log.info(e.getNomEvenement());
            }
        }
    }

    public Double montantParEvent(String nomev, TypeTicket typeTicket){
        return eventRepo.montantRecupereParEvt(nomev,typeTicket);
    }
}
