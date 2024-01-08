package tn.esprit.exam2024.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternaute;
    private String identifiant;
    @Enumerated(EnumType.STRING)
    private TrancheAge trancheAge;
    @OneToMany(mappedBy = "internaute")
    @JsonIgnore
    private Set<Ticket> tickets ;

}
