package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class PersonaRepoImpl implements IPersonaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		Query sqlQuery=this.entityManager.createNativeQuery("select * from persona", Persona.class);
		List<Persona> busquedaTotal=sqlQuery.getResultList();
		return busquedaTotal;
	}

	@Override
	public List<Persona> buscarId(Integer id) {
		// TODO Auto-generated method stub
		Query jpqlQuery= this.entityManager.createQuery("select p from Persona p where p.id=:datoEntrada");
		jpqlQuery.setParameter("datoEntrada", id);
		List<Persona> buscado=jpqlQuery.getResultList();
		return buscado;
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Query jpqlQuery = this.entityManager.createQuery("delete from Persona p where p.id =:datoEntrada");
		jpqlQuery.setParameter("datoEntrada", id);
		jpqlQuery.executeUpdate();
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

}
