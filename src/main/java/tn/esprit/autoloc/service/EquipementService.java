package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public Equipement update(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    public Optional<Equipement> findById(Long id) {
        return equipementRepository.findById(id);
    }

    public void deleteById(Long id) {
        equipementRepository.deleteById(id);
    }
}