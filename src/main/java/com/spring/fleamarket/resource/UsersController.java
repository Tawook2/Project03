package com.spring.fleamarket.resource;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.storage.UserStorage;

@RestController
@CrossOrigin
public class UsersController {

	@GetMapping("/registration/{userName}")
	public ResponseEntity<Void> register(@PathVariable String userName){
		System.out.println("handling register user request" + userName);
		
		try {
			UserStorage.getInstance().setUser(userName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		System.out.println("5678");
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/fetchAllUsers")
	public Set<String> fetchAll(){
		return UserStorage.getInstance().getUsers();
	}
	
}
