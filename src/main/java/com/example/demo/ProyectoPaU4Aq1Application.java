package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class ProyectoPaU4Aq1Application implements CommandLineRunner{

	@Autowired
	private IPersonaService iPersonaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4Aq1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Persona p1 = new Persona();
//		p1.setApellido("Conlago");
//		p1.setCedula("182312312");
//		p1.setNombre("Willian");
//		p1.setGenero("M");
//		
//		Persona p2 = new Persona();
//		p2.setApellido("Morales");
//		p2.setCedula("1272412312");
//		p2.setNombre("George");
//		p2.setGenero("M");
//	
//		this.iPersonaService.guardar(p1);
//		this.iPersonaService.guardar(p2);
//		Persona p1 = this.iPersonaService.buscarId(2).get(0);
//		p1.setCedula("19621312321");
//		this.iPersonaService.actualizar(p1);
//		this.iPersonaService.eliminar(1);
//		this.iPersonaService.eliminar(2);
//		this.iPersonaService.eliminar(3);
//		this.iPersonaService.eliminar(4);
		List<Persona> lista=this.iPersonaService.buscarTodos();
		lista.forEach(persona->System.out.println(persona));

	}

}
