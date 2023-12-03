package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Garde;
import ma.project.repositories.GardeRepository;


@Service
public class GardeService implements IDao<Garde> {

	@Autowired
	private GardeRepository gr;
	
	@Override
	public Garde craete(Garde o) {
		// TODO Auto-generated method stub
		return gr.save(o);
	}

	@Override
	public Garde update(Garde o) {
		// TODO Auto-generated method stub
		return gr.save(o);
	}

	@Override
	public boolean delete(Garde o) {
		 try {
	            gr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Garde> findAll() {
		// TODO Auto-generated method stub
		return gr.findAll();
	}

	@Override
	public Garde findById(Long id) {
		// TODO Auto-generated method stub
		return gr.findById(id).orElse(null);
	}

}
