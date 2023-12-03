package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.project.entities.Pharmacien;

public interface PharmacienRepository extends JpaRepository<Pharmacien, Long> {

}
