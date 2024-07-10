package com.ProyectoFinalCodoAcodo.Service;
import com.ProyectoFinalCodoAcodo.Repository.ActorRepository;
import com.ProyectoFinalCodoAcodo.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner {


	@Autowired
	private PeliculaRepository repository;

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	//@Override
	//public void run(String... args) throws Exception {
	//	Principal principal = new Principal(repository, actorRepository);
	//	principal.muestraElMenu();
	//}


}
