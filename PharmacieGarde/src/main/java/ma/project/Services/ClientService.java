package ma.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDao;
import ma.project.entities.Client;
import ma.project.repositories.ClientRepository;

@Service
public class ClientService implements IDao<Client> {

	@Autowired
	private ClientRepository cr;
	
	@Override
	public Client create(Client o) {
		// TODO Auto-generated method stub
		return cr.save(o);
	}

	@Override
	public Client update(Client o) {
		// TODO Auto-generated method stub
		return cr.save(o);
	}

	@Override
	public boolean delete(Client o) {
		 try {
	            cr.delete(o);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return cr.findById(id).orElse(null);
	}

}
