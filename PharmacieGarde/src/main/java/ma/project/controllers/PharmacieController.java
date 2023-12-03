package ma.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.Services.PharmacieService;
import ma.project.entities.Pharmacie;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacieController {
	@Autowired
	private PharmacieService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllPharmacies() {
        List<Pharmacie> batiments = ss.findAll();
        if (batiments.isEmpty()) {
            return new ResponseEntity<>("Aucun pharmacie est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(batiments);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Pharmacie> savePharmaciee(@RequestBody Pharmacie batiment){
		return new  ResponseEntity<Pharmacie>(ss.create(batiment),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Pharmacie bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Pharmacie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePharmacie(@PathVariable Long id, @RequestBody Pharmacie newPharmacie) {
		Pharmacie oldPharmacie = ss.findById(id);
		if (oldPharmacie == null) {
			return new ResponseEntity<Object>("Pharmacie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newPharmacie.setId(id);
			return ResponseEntity.ok(ss.update(newPharmacie));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePharmacie(@PathVariable Long id) {
		Pharmacie bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Pharmacie avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(bat);
			return ResponseEntity.ok("Pharmacie est  supprimée");
		}
	}


}

