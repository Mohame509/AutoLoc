package tn.esprit.autoloc;

import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@Commit
class AllRepositoriesTest {

    @Autowired private AgenceRepository agenceRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private ContratRepository contratRepository;
    @Autowired private EmployeRepository employeRepository;
    @Autowired private EquipementRepository equipementRepository;
    @Autowired private MaintenanceRepository maintenanceRepository;
    @Autowired private PaiementRepository paiementRepository;
    @Autowired private ReservationRepository reservationRepository;
    @Autowired private VehiculeRepository vehiculeRepository;

    @Test
    @DisplayName("Test JPA: Validation de AgenceRepository")
    void testAgenceRepository() {
        Agence entity = Agence.builder()
                .nom("Agence Tunis " + System.currentTimeMillis())
                .ville("Tunis")
                .adresse("Avenue Habib Bourguiba")
                .telephone("71000000")
                .build();

        Agence saved = agenceRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdAgence()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de ClientRepository")
    void testClientRepository() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        Client entity = Client.builder()
                .nom("Ben Ali")
                .prenom("Mohamed")
                .email("mohamed." + unique + "@esprit.tn")
                .numPermis("PERMIS-" + unique)
                .telephone("98000000")
                .dateInscription(LocalDate.now())
                .build();

        Client saved = clientRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdClient()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de ContratRepository")
    void testContratRepository() {
        Contrat entity = Contrat.builder()
                .dateSignature(LocalDate.now())
                .montantTotal(BigDecimal.valueOf(500.00))
                .valide(true)
                .build();
        Contrat saved = contratRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdContrat()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de EmployeRepository")
    void testEmployeRepository() {
        Agence agence = agenceRepository.save(Agence.builder()
                .nom("Agence Employe " + System.currentTimeMillis())
                .ville("Tunis")
                .adresse("Avenue Habib Bourguiba")
                .telephone("71000000")
                .build());

        Employe entity = Employe.builder()
                .nom("Gharbi")
                .prenom("Sami")
                .role(RoleEmploye.values()[0])
                .agence(agence)
                .build();

        Employe saved = employeRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdEmploye()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de EquipementRepository")
    void testEquipementRepository() {
        Equipement entity = Equipement.builder()
                .libelle("GPS Navigation " + System.currentTimeMillis())
                .build();

        Equipement saved = equipementRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdEquipement()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de MaintenanceRepository")
    void testMaintenanceRepository() {
        Agence agence = agenceRepository.save(Agence.builder()
                .nom("Agence Maint " + System.currentTimeMillis())
                .ville("Tunis")
                .adresse("Avenue Habib Bourguiba")
                .telephone("71000000")
                .build());

        String uniqueMatricule = (int)(Math.random() * 9000 + 1000) + "-TN-" + (int)(Math.random() * 9000 + 1000);
        Vehicule vehicule = vehiculeRepository.save(Vehicule.builder()
                .immatriculation(uniqueMatricule)
                .marque("Peugeot")
                .modele("208")
                .categorie(CategorieVehicule.values()[0])
                .statut(StatutVehicule.values()[0])
                .tarifJournalier(BigDecimal.valueOf(80.00))
                .agence(agence)
                .build());

        Maintenance entity = Maintenance.builder()
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(2))
                .description("Changement d'huile et filtres")
                .vehicule(vehicule)
                .build();

        Maintenance saved = maintenanceRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdMaintenance()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de PaiementRepository")
    void testPaiementRepository() {
        Contrat contrat = contratRepository.save(Contrat.builder()
                .dateSignature(LocalDate.now())
                .montantTotal(BigDecimal.valueOf(250.00))
                .valide(true)
                .build());

        Paiement entity = Paiement.builder()
                .montant(BigDecimal.valueOf(150.00))
                .datePaiement(LocalDate.now())
                .modePaiement(ModePaiement.values()[0])
                .contrat(contrat)
                .build();

        Paiement saved = paiementRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdPaiement()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de ReservationRepository")
    void testReservationRepository() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        Client client = clientRepository.save(Client.builder()
                .nom("Ben Ali")
                .prenom("Mohamed")
                .email("client." + unique + "@esprit.tn")
                .numPermis("PERM-" + unique)
                .telephone("98000000")
                .dateInscription(LocalDate.now())
                .build());

        Agence agence = agenceRepository.save(Agence.builder()
                .nom("Agence Res " + System.currentTimeMillis())
                .ville("Tunis")
                .adresse("Avenue Habib Bourguiba")
                .telephone("71000000")
                .build());

        String uniqueMatricule = (int)(Math.random() * 9000 + 1000) + "-TN-" + (int)(Math.random() * 9000 + 1000);
        Vehicule vehicule = vehiculeRepository.save(Vehicule.builder()
                .immatriculation(uniqueMatricule)
                .marque("Toyota")
                .modele("Yaris")
                .categorie(CategorieVehicule.values()[0])
                .statut(StatutVehicule.values()[0])
                .tarifJournalier(BigDecimal.valueOf(85.00))
                .agence(agence)
                .build());

        Reservation entity = Reservation.builder()
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(5))
                .statut(StatutReservation.values()[0])
                .client(client)
                .vehicule(vehicule)
                .build();

        Reservation saved = reservationRepository.save(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdReservation()).isNotNull();
    }

    @Test
    @DisplayName("Test JPA: Validation de VehiculeRepository")
    void testVehiculeRepository() {
        Agence agence = agenceRepository.save(Agence.builder()
                .nom("Agence Vehicule " + System.currentTimeMillis())
                .ville("Tunis")
                .adresse("Avenue Habib Bourguiba")
                .telephone("71000000")
                .build());

        // Immatriculation dynamique pour éviter la contrainte UNIQUE
        String uniqueMatricule = (int)(Math.random() * 9000 + 1000) + "-TN-" + (int)(Math.random() * 9000 + 1000);

        Vehicule entity = Vehicule.builder()
                .immatriculation(uniqueMatricule)
                .marque("Renault")
                .modele("Clio")
                .categorie(CategorieVehicule.values()[0])
                .statut(StatutVehicule.values()[0])
                .tarifJournalier(BigDecimal.valueOf(90.00))
                .agence(agence)
                .build();

        Vehicule saved = vehiculeRepository.saveAndFlush(entity);
        assertThat(saved).isNotNull();
        assertThat(saved.getIdVehicule()).isNotNull();
    }
}