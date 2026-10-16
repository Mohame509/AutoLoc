package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    public Optional<Maintenance> findById(Long id) {
        return maintenanceRepository.findById(id);
    }

    public void deleteById(Long id) {
        maintenanceRepository.deleteById(id);
    }
}