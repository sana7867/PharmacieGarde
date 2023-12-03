package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import ma.project.entities.PharmacieGarde;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Long> {

}
