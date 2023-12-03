package ma.project.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.PharmacieGarde;
import ma.project.repositories.PharmacieGardeRepository;

@Service
public class PharmacieGardeService implements IDao<PharmacieGarde> {

	@Autowired
	private PharmacieGardeRepository pgr;
	
	@Override
	public PharmacieGarde create(PharmacieGarde o) {
		
		// TODO Auto-generated method stub
		return pgr.save(o);
	}

	@Override
	public PharmacieGarde update(PharmacieGarde o) {
		// TODO Auto-generated method stub
		return pgr.save(o);
	}

	@Override
	public boolean delete(PharmacieGarde o) {
		 try {
	            pgr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<PharmacieGarde> findAll() {
		// TODO Auto-generated method stub
		return pgr.findAll();
	}

	@Override
	public PharmacieGarde findById(Long id) {
		// TODO Auto-generated method stub
		return pgr.findById(id).orElse(null);
	}

}

