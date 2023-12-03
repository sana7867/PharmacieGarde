package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.*;
import ma.project.entities.Users;
import ma.project.repositories.UserRepository;

@Service
public class UsersService implements IDao<Users> {

	@Autowired
	private UserRepository us;
	
	@Override
	public Users craete(Users o) {
		// TODO Auto-generated method stub
		return us.save(o);
	}

	@Override
	public Users update(Users o) {
		// TODO Auto-generated method stub
		return us.save(o);
	}

	@Override
	public boolean delete(Users o) {
		 try {
	            us.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return us.findAll();
	}

	@Override
	public Users findById(Long id) {
		// TODO Auto-generated method stub
		return us.findById(id).orElse(null);
	}

}
