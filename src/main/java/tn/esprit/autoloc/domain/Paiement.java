package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    @Column(nullable = false)
    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModePaiement modePaiement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;
}