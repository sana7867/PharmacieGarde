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

import ma.project.Services.UsersService;
import ma.project.entities.Users;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService ss;
	@GetMapping("/all")
	public ResponseEntity<Object> findAllUserss() {
        List<Users> userss = ss.findAll();
        if (userss.isEmpty()) {
            return new ResponseEntity<>("Aucun user est trouvé", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(userss);
        }
    }

	@PostMapping("/save")
	public ResponseEntity<Users> saveUserse(@RequestBody Users users){
		return new  ResponseEntity<Users>(ss.create(users),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Users user = ss.findById(id);
		if (user == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(user);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsers(@PathVariable Long id, @RequestBody Users newUsers) {
		Users oldUsers = ss.findById(id);
		if (oldUsers == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newUsers.setId(id);
			return ResponseEntity.ok(ss.update(newUsers));
		}
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsers(@PathVariable Long id) {
		Users user = ss.findById(id);
		if (user == null) {
			return new ResponseEntity<Object>("User avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			ss.delete(user);
			return ResponseEntity.ok("User est  supprimée");
		}
	}


}