package ma.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.Services.AdminService;
import ma.project.entities.Administrateur;

@RestController
@RequestMapping("/api/administrateurs")
public class AdministrateurController {
	@Autowired
	private AdminService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllAdministrateurs() {
        List<Administrateur> administrateurs = ss.findAll();
        if (administrateurs.isEmpty()) {
            return new ResponseEntity<>("Aucun administrateur est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(administrateurs);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Administrateur> saveAdministrateure(@RequestBody Administrateur administrateur){
		return new  ResponseEntity<Administrateur>(ss.create(administrateur),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Administrateur adm = ss.findById(id);
		if (adm == null) {
			return new ResponseEntity<Object>("Administrateur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(adm);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur newAdministrateur) {
		Administrateur oldAdministrateur = ss.findById(id);
		if (oldAdministrateur == null) {
			return new ResponseEntity<Object>("Administrateur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newAdministrateur.setId(id);
			return ResponseEntity.ok(ss.update(newAdministrateur));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAdministrateur(@PathVariable Long id) {
		Administrateur adm = ss.findById(id);
		if (adm == null) {
			return new ResponseEntity<Object>("Administrateur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(adm);
			return ResponseEntity.ok("Administrateur est  supprimée");
		}
	}


}


