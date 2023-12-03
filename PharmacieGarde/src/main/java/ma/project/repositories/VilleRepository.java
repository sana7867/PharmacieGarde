package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.entities.Ville;

@Repository
public interface VilleRepository extends JpaRepository< Ville, Long> {

}
