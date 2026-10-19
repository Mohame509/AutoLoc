package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.AgenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@CrossOrigin(origins = "*")
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        return agenceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Agence> create(@RequestBody Agence agence) {
        Agence created = agenceService.create(agence);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(id);
        Agence updated = agenceService.update(agence);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (agenceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        agenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
