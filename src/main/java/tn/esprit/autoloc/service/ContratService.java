package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    public Optional<Contrat> findById(Long id) {
        return contratRepository.findById(id);
    }

    public void deleteById(Long id) {
        contratRepository.deleteById(id);
    }
}