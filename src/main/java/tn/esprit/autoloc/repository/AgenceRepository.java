package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {


}