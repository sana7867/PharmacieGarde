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

import ma.project.Services.ClientService;
import ma.project.entities.Client;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	@Autowired
	private ClientService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllClients() {
        List<Client> clients = ss.findAll();
        if (clients.isEmpty()) {
            return new ResponseEntity<>("Aucun client est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(clients);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Client> saveCliente(@RequestBody Client client){
		return new  ResponseEntity<Client>(ss.create(client),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Client clt = ss.findById(id);
		if (clt == null) {
			return new ResponseEntity<Object>("Client avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(clt);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody Client newClient) {
		Client oldClient = ss.findById(id);
		if (oldClient == null) {
			return new ResponseEntity<Object>("Client avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newClient.setId(id);
			return ResponseEntity.ok(ss.update(newClient));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable Long id) {
		Client clt = ss.findById(id);
		if (clt == null) {
			return new ResponseEntity<Object>("Client avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(clt);
			return ResponseEntity.ok("Client est  supprimée");
		}
	}


}

