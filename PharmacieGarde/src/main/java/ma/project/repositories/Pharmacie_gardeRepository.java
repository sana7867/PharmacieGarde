package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.entities.Pharmacie_garde;

@Repository
public interface Pharmacie_gardeRepository extends JpaRepository<Pharmacie_garde, Long> {

}
