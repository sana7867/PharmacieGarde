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

import ma.project.Services.GardeService;
import ma.project.entities.Garde;



@RestController
@RequestMapping("/api/gardes")
public class GardeController {
	@Autowired
	private GardeService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllGardes() {
        List<Garde> gardes = ss.findAll();
        if (gardes.isEmpty()) {
            return new ResponseEntity<>("Aucun garde est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(gardes);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Garde> saveGardee(@RequestBody Garde garde){
		return new  ResponseEntity<Garde>(ss.create(garde),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Garde bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Garde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateGarde(@PathVariable Long id, @RequestBody Garde newGarde) {
		Garde oldGarde = ss.findById(id);
		if (oldGarde == null) {
			return new ResponseEntity<Object>("Garde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newGarde.setId(id);
			return ResponseEntity.ok(ss.update(newGarde));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGarde(@PathVariable Long id) {
		Garde bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Garde avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(bat);
			return ResponseEntity.ok("Garde est  supprimée");
		}
	}


}

