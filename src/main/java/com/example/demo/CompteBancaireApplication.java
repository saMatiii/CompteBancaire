package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.entities.*;
import com.example.demo.metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CompteBancaireApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
    @Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanque iBanque;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository rolesRepository;

	public static void main(String[] args) {
		 SpringApplication.run(CompteBancaireApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
     Client c1	=clientRepository.save(new Client("mail@gmail.com","hassan"));
		Client c2=clientRepository.save(new Client("rachid@gmail.com","rachid"));
		Compte ct1=compteRepository.save(new CompteCourant("c1",new Date(),9000,c1,6000));
		Compte ct2=compteRepository.save(new CompteEpargne("c2",new Date(),9000,c2,6.3));
		Operation op=operationRepository.save(new Versement(new Date(),5000,ct1));
		Operation op2=operationRepository.save(new Retrait(new Date(),5000,ct1));
		iBanque.verser("c1",2222);


		Roles role1=rolesRepository.save(new Roles("ADMIN"));
		Roles role2=rolesRepository.save(new Roles("USER"));

		List<Roles> rolesList = new ArrayList<Roles>();
		rolesList.add(role2);
		Users users=userRepository.save(new Users("abdessamad", "azer","azer@gmail.com",true));
		users.setRoles(rolesList);
		userRepository.save(users);

		List<Roles> rolesList2 = new ArrayList<Roles>();
		rolesList2.add(role1);
		Users users2=userRepository.save(new Users("imane","imane","azer@gmail.com",true));
		users2.setRoles(rolesList2);
		userRepository.save(users2);

		List<Roles> rolesList3 = new ArrayList<Roles>();
		rolesList3.add(role1);
		Users userss=userRepository.save(new Users("sami", "sami","azer@gmail.com",true));
		userss.setRoles(rolesList3);
		userRepository.save(userss);

	}
}
