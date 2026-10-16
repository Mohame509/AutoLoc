package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String adresse;

    private String telephone;

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Vehicule> vehicules;

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Employe> employes;
}