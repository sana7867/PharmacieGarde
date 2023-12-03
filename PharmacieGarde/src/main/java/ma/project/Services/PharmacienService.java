package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Pharmacien;
import ma.project.repositories.PharmacienRepository;

@Service
public class PharmacienService implements IDao<Pharmacien> {

	@Autowired
	private PharmacienRepository pr;
	
	@Override
	public Pharmacien create(Pharmacien o) {
		// TODO Auto-generated method stub
		return pr.save(o);
	}

	@Override
	public Pharmacien update(Pharmacien o) {
		// TODO Auto-generated method stub
		return pr.save(o);
	}

	@Override
	public boolean delete(Pharmacien o) {
		 try {
	            pr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Pharmacien> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Pharmacien findById(Long id) {
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(null);
	}

}

