package tn.esprit.exam2024.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam2024.entities.*;
import tn.esprit.exam2024.repository.EventRepo;
import tn.esprit.exam2024.repository.InternauteRepo;
import tn.esprit.exam2024.repository.TicketRepo;
import tn.esprit.exam2024.services.EventService;
import tn.esprit.exam2024.services.InternauteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private InternauteService internauteService;
    private EventService eventService;
    private TicketRepo ticketRepo;
    private EventRepo eventRepo;
    private InternauteRepo internauteRepo;


    @PostMapping("/internaute")
    public Internaute ajouterInternaute(@RequestBody Internaute internaute){
        return internauteService.ajouterInternaute(internaute);
    }

    @PostMapping("/event")
    public Evenement ajouterEvenement(@RequestBody Evenement evenement){
        return eventService.ajouterEvenement(evenement);
    }

    @GetMapping("/nbr")
    public Long nbInternaute(@RequestParam TrancheAge trancheAge,@RequestParam  LocalDate d1,@RequestParam  LocalDate d2){
        return internauteService.nbInternaute(trancheAge,d1,d2);
    }

    @PostMapping("/ticket")
    List<Ticket> ajouterTicketEtAffecterAEvent (@RequestBody List<Ticket> tickets, Long idevent, Long idInetrnaute){

        Evenement evenement = eventRepo.findById(idevent).orElse(null);
        Internaute internaute = internauteRepo.findById(idInetrnaute).orElse(null);
        if (tickets.size() < evenement.getNbPlacesRestants()) {
            for (Ticket t : tickets) {
                t.setEvenement(evenement);
                t.setInternaute(internaute);
                ticketRepo.save(t);
            }
        }else{
            throw new UnsupportedOperationException("nombre de places demandée indisponible");
        }
        return tickets;
    }

    @GetMapping("/montant")
    public Double montantParEvent(@RequestParam String nomev,@RequestParam TypeTicket typeTicket){
        return eventService.montantParEvent(nomev,typeTicket);
    }
}
