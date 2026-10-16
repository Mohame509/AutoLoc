package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {


}