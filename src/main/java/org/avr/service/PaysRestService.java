package org.avr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.avr.dao.PaysRepository;
import org.avr.entities.Pays;
import org.avr.entities.Region;
import org.avr.metier.PaysMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysRestService {
	@Autowired
	private PaysMetier paysMetier;

//@Secured(value={"ROLE_ADMIN","ROLE_CHEF AGENCE"})//defini les personnes qui ont droits sur une méthode.ROLE_:prefix ajouter par Spring security sur les roles definis
   @RequestMapping(value="/Pays",method=RequestMethod.POST)
	public Pays savePays(@RequestBody Pays p) {
		return paysMetier.savePays(p);
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_CHEF AGENCE","ROLE_CLIENT","ROLE_CHAUFFEUR","ROLE_COMPTABLE"})
   @RequestMapping(value="/Pays",method=RequestMethod.GET)
	public List<Pays> getAllpays() {
		return paysMetier.getAllpays();
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_CHEF AGENCE"})
	@RequestMapping(value="/Pays/{id}",method=RequestMethod.PUT)
	public Pays updatePays(@PathVariable Long id, @RequestBody Pays p) {
		return paysMetier.updatePays(id, p);
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/Pays/{id}",method=RequestMethod.DELETE) 
	public boolean deletePays(@PathVariable Long id) {
		return paysMetier.deletePays(id);
	}
	@RequestMapping(value="/PaysParMC",method=RequestMethod.GET)
	public Page<Pays> paysParMc(
			@RequestParam (name="mc", defaultValue="")String mc, 
			@RequestParam (name="page", defaultValue="0")int page, 
			@RequestParam (name="size", defaultValue="5")int size) {
		return paysMetier.paysParMc(mc, page, size);
	}
	@RequestMapping(value="/Pays/{id}",method=RequestMethod.GET)
	public Pays getPays(@PathVariable Long id) {
		return paysMetier.getPays(id);
	}
	
	@RequestMapping(value="/RegionParPays/{idPays}",method=RequestMethod.GET)
	public List<Region> RegionParPays(@PathVariable Long idPays) {
		return paysMetier.RegionParPays(idPays);
	}
	/*pour pouvoir récuperer un user et son role, on a besoin d'écrire cette
	 * methode: qui va s'en charger de recuperer les donnees au format json
	 * */
	/*@RequestMapping(value="/getLogedUser")
	public Map<String, Object> consulUserAuthentifier(HttpServletRequest httpServletRequest){
		HttpSession httpSession=httpServletRequest.getSession();//permet de récupérer la session encours
		SecurityContext securityContext=(SecurityContext) 
				httpSession.getAttribute("SPRING_SECURITY_CONTEXT");//recupere l'attribut SPRING_SECURITY_CONTEXT(contexte de la securité) stocker dans SecurityContext
		String username= securityContext.getAuthentication().getName();//recupere le nom de l'user authentifé
		//recuperation de la liste des roles d'un user
		List<String> roles= new ArrayList<>();
		for(GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority()); //recupere differents roles des utilisateurs
		}
		//ajout de l'user et ces roles dans une collection Map
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}*/

}
