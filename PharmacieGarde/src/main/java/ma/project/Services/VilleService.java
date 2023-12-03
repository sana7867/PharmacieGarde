package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Ville;
import ma.project.repositories.VilleRepository;

@Service
public class VilleService implements IDao<Ville> {

	@Autowired
	private VilleRepository vr;
	
	@Override
	public Ville craete(Ville o) {
		// TODO Auto-generated method stub
		return vr.save(o);
	}

	@Override
	public Ville update(Ville o) {
		// TODO Auto-generated method stub
		return vr.save(o);
	}

	@Override
	public boolean delete(Ville o) {
		 try {
	            vr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	@Override
	public Ville findById(Long id) {
		// TODO Auto-generated method stub
		return vr.findById(id).orElse(null);
	}

}

