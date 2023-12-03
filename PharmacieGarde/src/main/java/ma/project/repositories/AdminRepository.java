package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.entities.Administrateur;

@Repository
public interface AdminRepository extends JpaRepository<Administrateur, Long> {

}
