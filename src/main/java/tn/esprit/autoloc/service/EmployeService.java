package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }

    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    public Optional<Employe> findById(Long id) {
        return employeRepository.findById(id);
    }

    public void deleteById(Long id) {
        employeRepository.deleteById(id);
    }
}