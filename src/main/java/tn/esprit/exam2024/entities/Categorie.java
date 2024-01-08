package tn.esprit.exam2024.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String codeCategorie;
    private String nomCategorie;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Evenement> evenements ;

}
