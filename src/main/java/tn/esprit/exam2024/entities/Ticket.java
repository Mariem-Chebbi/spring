package tn.esprit.exam2024.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String codeTicket;
    private Double prixTicket;
    @Enumerated(EnumType.STRING)
    private TypeTicket typeTicket;
    @ManyToOne
    private Internaute internaute;
    @ManyToOne
    private Evenement evenement;


}
