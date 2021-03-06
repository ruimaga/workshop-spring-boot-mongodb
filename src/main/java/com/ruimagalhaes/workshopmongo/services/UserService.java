package com.ruimagalhaes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruimagalhaes.workshopmongo.domain.User;
import com.ruimagalhaes.workshopmongo.dto.UserDTO;
import com.ruimagalhaes.workshopmongo.repository.UserRepository;
import com.ruimagalhaes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		
		return repo.findAll();
		
	}
	
    @SuppressWarnings("unchecked")
	public User findById(String id) {
		
    	Optional<User> obj = repo.findById(id);
    	return (User) obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
    
    public User insert(User obj) {
    	
    	return repo.insert(obj);
		
	}
    
    public void delete(String id) {
    	
    	findById(id);
    	repo.deleteById(id);
		
	}
    
    public User update(User obj) {
    	User newObj = findById(obj.getId());
    	updateData(newObj, obj);
    	return repo.save(newObj);
    	}

    
    private void updateData(User newObj, User obj) {
		
    	newObj.setNome(obj.getNome());
    	newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO (UserDTO objDTO) {
    	
    	return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
		
	}
    
 }
