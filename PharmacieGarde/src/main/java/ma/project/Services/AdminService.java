package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Administrateur;
import ma.project.repositories.AdminRepository;


@Service
public class AdminService implements IDao<Administrateur> {

	@Autowired
	private AdminRepository ar;
	
	@Override
	public Administrateur create(Administrateur o) {
		// TODO Auto-generated method stub
		return ar.save(o);
	}

	@Override
	public Administrateur update(Administrateur o) {
		// TODO Auto-generated method stub
		return ar.save(o);
	}

	@Override
	public boolean delete(Administrateur o) {
		 try {
	            ar.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Administrateur> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Administrateur findById(Long id) {
		// TODO Auto-generated method stub
		return ar.findById(id).orElse(null);
	}

}
