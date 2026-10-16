package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement update(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> findById(Long id) {
        return paiementRepository.findById(id);
    }

    public void deleteById(Long id) {
        paiementRepository.deleteById(id);
    }
}