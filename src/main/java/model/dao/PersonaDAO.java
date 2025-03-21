package model.dao;

import model.entities.Persona;
import org.hibernate.Session;

import java.util.List;

public class PersonaDAO
{
	private Session session;

	public PersonaDAO(Session session)
	{
		this.session = session;
	}

	public Persona findById(Long id)
	{
		session.beginTransaction();
		Persona res = session.get(Persona.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Persona> findAll()
	{
		session.beginTransaction();
		List<Persona> res = session.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}
}
