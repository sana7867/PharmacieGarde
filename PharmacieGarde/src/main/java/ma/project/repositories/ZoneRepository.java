package ma.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.entities.Users;
import ma.project.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository< Zone, Long> {

}