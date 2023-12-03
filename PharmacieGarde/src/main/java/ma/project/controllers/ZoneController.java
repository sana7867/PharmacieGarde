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

import ma.project.Services.ZoneService;
import ma.project.entities.Zone;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	@Autowired
	private ZoneService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllZones() {
        List<Zone> zones = ss.findAll();
        if (zones.isEmpty()) {
            return new ResponseEntity<>("Aucun zone est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(zones);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Zone> saveZonee(@RequestBody Zone zone){
		return new  ResponseEntity<Zone>(ss.create(zone),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Zone bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Zone avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(bat);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateZone(@PathVariable Long id, @RequestBody Zone newZone) {
		Zone oldZone = ss.findById(id);
		if (oldZone == null) {
			return new ResponseEntity<Object>("Zone avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newZone.setId(id);
			return ResponseEntity.ok(ss.update(newZone));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteZone(@PathVariable Long id) {
		Zone bat = ss.findById(id);
		if (bat == null) {
			return new ResponseEntity<Object>("Zone avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(bat);
			return ResponseEntity.ok("Zone est  supprimée");
		}
	}


}