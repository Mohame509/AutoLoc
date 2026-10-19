package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "*")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable Long id) {
        return employeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employe> create(@RequestBody Employe employe) {
        Employe created = employeService.create(employe);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        if (employeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employe.setIdEmploye(id);
        Employe updated = employeService.update(employe);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (employeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
