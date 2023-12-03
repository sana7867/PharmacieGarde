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

import ma.project.Services.VilleService;
import ma.project.entities.Ville;

@RestController
@RequestMapping("/api/villes")
public class VilleController {
	@Autowired
	private VilleService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllVilles() {
        List<Ville> villes = ss.findAll();
        if (villes.isEmpty()) {
            return new ResponseEntity<>("Aucun ville est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(villes);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Ville> saveVillee(@RequestBody Ville ville){
		return new  ResponseEntity<Ville>(ss.create(ville),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Ville bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Ville avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateVille(@PathVariable Long id, @RequestBody Ville newVille) {
		Ville oldVille = ss.findById(id);
		if (oldVille == null) {
			return new ResponseEntity<Object>("Ville avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newVille.setId(id);
			return ResponseEntity.ok(ss.update(newVille));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVille(@PathVariable Long id) {
		Ville bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Ville avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(bat);
			return ResponseEntity.ok("Ville est  supprimée");
		}
	}


}
