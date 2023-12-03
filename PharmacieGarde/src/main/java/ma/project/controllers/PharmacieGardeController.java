package ma.project.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ma.project.Services.PharmacieGardeService;
import ma.project.entities.PharmacieGarde;


@RestController
@RequestMapping("/api/Pharmacie_gardes")
public class PharmacieGardeController {
	@Autowired
	private PharmacieGardeService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllPharmacieGardes() {
        List<PharmacieGarde> pharmacieGardes = ss.findAll();
        if (pharmacieGardes.isEmpty()) {
            return new ResponseEntity<>("Aucun garde est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(pharmacieGardes);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<PharmacieGarde> savePharmacieGardee(@RequestBody PharmacieGarde pharmacieGarde){
		return new  ResponseEntity<PharmacieGarde>(ss.create(pharmacieGarde),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		PharmacieGarde bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("PharmacieGarde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePharmacieGarde(@PathVariable Long id, @RequestBody PharmacieGarde newPharmacieGarde) {
		PharmacieGarde oldPharmacieGarde = ss.findById(id);
		if (oldPharmacieGarde == null) {
			return new ResponseEntity<Object>("PharmacieGarde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newPharmacieGarde.setId(id);
			return ResponseEntity.ok(ss.update(newPharmacieGarde));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePharmacieGarde(@PathVariable Long id) {
		PharmacieGarde bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("PharmacieGarde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(bat);
			return ResponseEntity.ok("PharmacieGarde est  supprimée");
		}
	}


}

