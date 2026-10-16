package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {


}