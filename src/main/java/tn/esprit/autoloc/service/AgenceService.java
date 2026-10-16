package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceService {

    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    }

    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    public Optional<Agence> findById(Long id) {
        return agenceRepository.findById(id);
    }

    public void deleteById(Long id) {
        agenceRepository.deleteById(id);
    }
}