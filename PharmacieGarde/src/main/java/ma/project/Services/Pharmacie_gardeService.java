package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Pharmacie_garde;
import ma.project.repositories.Pharmacie_gardeRepository;

@Service
public class Pharmacie_gardeService implements IDao<Pharmacie_garde> {

	@Autowired
	private Pharmacie_gardeRepository pgr;
	
	@Override
	public Pharmacie_garde craete(Pharmacie_garde o) {
		
		// TODO Auto-generated method stub
		return pgr.save(o);
	}

	@Override
	public Pharmacie_garde update(Pharmacie_garde o) {
		// TODO Auto-generated method stub
		return pgr.save(o);
	}

	@Override
	public boolean delete(Pharmacie_garde o) {
		 try {
	            pgr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Pharmacie_garde> findAll() {
		// TODO Auto-generated method stub
		return pgr.findAll();
	}

	@Override
	public Pharmacie_garde findById(Long id) {
		// TODO Auto-generated method stub
		return pgr.findById(id).orElse(null);
	}

}

