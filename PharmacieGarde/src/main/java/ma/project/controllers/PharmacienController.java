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

import ma.project.Services.PharmacienService;
import ma.project.entities.Pharmacien;

@RestController
@RequestMapping("/api/pharmaciens")
public class PharmacienController {
	@Autowired
	private PharmacienService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllPharmaciens() {
        List<Pharmacien> pharmaciens = ss.findAll();
        if (pharmaciens.isEmpty()) {
            return new ResponseEntity<>("Aucun pharmacien est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(pharmaciens);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Pharmacien> savePharmaciene(@RequestBody Pharmacien pharmacien){
		return new  ResponseEntity<Pharmacien>(ss.create(pharmacien),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Pharmacien phrm = ss.findById(id);
		if (phrm == null) {
			return new ResponseEntity<Object>("Pharmacien avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(phrm);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePharmacien(@PathVariable Long id, @RequestBody Pharmacien newPharmacien) {
		Pharmacien oldPharmacien = ss.findById(id);
		if (oldPharmacien == null) {
			return new ResponseEntity<Object>("Pharmacien avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newPharmacien.setId(id);
			return ResponseEntity.ok(ss.update(newPharmacien));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePharmacien(@PathVariable Long id) {
		Pharmacien phrm = ss.findById(id);
		if (phrm == null) {
			return new ResponseEntity<Object>("Pharmacien avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(phrm);
			return ResponseEntity.ok("Pharmacien est  supprimée");
		}
	}


}


