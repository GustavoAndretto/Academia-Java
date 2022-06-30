package com.example.crudmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crudmysql.model.User;
import com.example.crudmysql.model.UserRepository;

@Controller // Informa que classe UserController é o nosso controller
@RequestMapping(path = "/crud")
public class UserController {
	@Autowired // ela serv para nos comunicar com UserRepository
	private UserRepository userRepository;

	// Create
	@PostMapping(path="/add")
	public @ResponseBody String addUser(@RequestParam String nome, @RequestParam String email) {

		// realiza o incapsulamento dos dasos
		User u = new User();
		u.setNome(nome);
		u.setEmail(email);
		// salvar o novo Usuario no banco
		userRepository.save(u);
		return "Salvo";
	}

	// Read - select * from user
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> allUser() {

		return userRepository.findAll();
	}

	// update
	@PutMapping(path="/update")
	public @ResponseBody String updateUser(@RequestParam Integer id, @RequestParam String nome, 
			@RequestParam String email) {
		User u = userRepository.findById(id).get();
		if(!nome.isEmpty()) {
			u.setNome(nome);
		}
		if(!email.isEmpty()) {
			u.setEmail(email);
		}
		userRepository.save(u);
		
		return "Alterado";
	}

	// Delete
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteUser(@RequestParam Integer id) {
		userRepository.deleteById(id);
		return "Apagado";
	}
}
