package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.ContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin(origins = "*")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        return contratService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contrat> create(@RequestBody Contrat contrat) {
        Contrat created = contratService.create(contrat);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        if (contratService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        contrat.setIdContrat(id);
        Contrat updated = contratService.update(contrat);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contratService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        contratService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
