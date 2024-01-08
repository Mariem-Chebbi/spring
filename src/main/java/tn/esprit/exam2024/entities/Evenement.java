package tn.esprit.exam2024.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;
    private String nomEvenement;
    private Long nbPlacesRestants;
    private LocalDate dateEvenement;
    @OneToMany(mappedBy = "evenement")
    @JsonIgnore
    private Set<Ticket> tickets ;
    @ManyToMany
    private Set<Categorie> categories ;


}
