package org.avr;

import javax.sql.DataSource;
/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration //@configuration permet de scanner l'appli au moment du démarrage
@EnableWebSecurity //sans cette anotation, les droits ne seront pas executés
@EnableGlobalMethodSecurity(securedEnabled=true) //permet a Spring de prendre en consideration @secured des methodes RestControllers
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
    public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
	//acces global
	@Autowired
	public void gobalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception{
		/* bloc des tests avec les user paramétrés; DataSource dataSource:ajouter pour le 2eme bloc
		inMemoryAuthentication(): ça veut dire que l'on veut récuperer les users en memoire (pour des petites applications)
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","PROF");//utilisateur avec 2 roles
		auth.inMemoryAuthentication().withUser("prof1").password("{noop}123").roles("PROF");//{noop} annule le problem de no passwordEncording id="null"
		auth.inMemoryAuthentication().withUser("et1").password("{noop}123").roles("ETUDIANT");
		auth.inMemoryAuthentication().withUser("sco1").password("{noop}123").roles("SCOLARITE");
		*/
		//bloc des tests avec les users de la bd
		/*auth.jdbcAuthentication() //pilote jdbc
		   .dataSource(dataSource) //grace a @autowired spring va chercher la bd et l'injecter
		     .usersByUsernameQuery("select login as principal, password as credentials, true from Utilisateur where login= ?") //absolument mettre les expressions:as principal et as credentials 
		     	.authoritiesByUsernameQuery("select utilisateur_login as principal, roles_role as role from utilisateur_roles where utilisateur_login= ?")//jointure entre user et role
		     	 .rolePrefix("ROLE_")//spefication des prefix
		     	 .passwordEncoder(passwordEncoder());//annule le problem de no passwordEncording id="null" coté bd
	}
	// cette methode permet d'indiquer quel ressource on veut protéger
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//authentifier toute les requetes
		  http
		  		.csrf().disable()//permet de desactiver cette ligne (jeton) de la page d'authentification:<input type="hidden" name="_csrf" value="0276ca41-904f-4769-b620-15b431e47bf1"/> généré par Spring security
		  		.authorizeRequests()
		  			.antMatchers("/css/**","/js/**","/images/**").permitAll()//autorise les ressource qui seront prisent en charge lors du demarrage
		  			.anyRequest()
		  				.authenticated()// fin premiere etape et debut deuxieme etape
		  				 .and()
		  		 .formLogin() //on indique l'url du formulaire dont on veut accéder
		  			.loginPage("/login")//fin deuxieme etape et debut trosieme etape
		  			 .permitAll()	//donne accès au formulaire /login et il faut penser a le créer ce formulaire
		  			.defaultSuccessUrl("/index.html")//defini la page d'affichage par défaut
		  			.failureUrl("/errors.html");//retourne cette page lorsque l'utilisateur n'existe pas
		             
	}*/

//}  
