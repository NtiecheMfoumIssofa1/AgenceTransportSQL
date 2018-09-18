package org.avr.service;

import java.util.List;

import org.avr.dao.RoleRepository;
import org.avr.dao.UtilisateurRepository;
import org.avr.entities.Role;
import org.avr.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Secured(value={"ROLE_ADMIN"}) //uniquement l'administrateur a droit a accéder a ces méthodes
public class UtilisateurRestService {
	@Autowired
	public UtilisateurRepository utilisateurRepository;
	@Autowired
	public RoleRepository roleRepository;
	
	@RequestMapping(value="/addUser")
	public Utilisateur saveUser(Utilisateur u){
		return utilisateurRepository.save(u);
	}
	@RequestMapping(value="/findUsers")
	public List<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role saveRole(Role r){
		return roleRepository.save(r);
	}
	@RequestMapping(value="/findRole")
	public List<Role> findAllRole(){
		return roleRepository.findAll();
	}
	//methode affecter un role a un utilisateur
		@RequestMapping(value="/addRoleToUser")
		public Utilisateur addRoleToUser(String username, String role){
			Utilisateur u=utilisateurRepository.getOne(username);//charger l'utilisateur
			Role r=roleRepository.getOne(role);//charger le role
			u.getRoles().add(r);//ajout du role a l'user association unidirectionnelle
			utilisateurRepository.save(u);//mettre a jour les roles de l'user
			return u;
		}

}
