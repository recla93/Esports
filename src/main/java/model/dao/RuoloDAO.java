package model.dao;

import model.entities.Rendimento;
import model.entities.Ruolo;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class RuoloDAO
{
	private Session session;

	public RuoloDAO(Session session)
	{
		this.session = session;
	}

	public Ruolo findById(Long id)
	{
		session.beginTransaction();
		Ruolo res = session.get(Ruolo.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Ruolo> findAll()
	{
		session.beginTransaction();
		List<Ruolo> res = session.createQuery("SELECT r FROM Ruolo r", Ruolo.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Ruolo r)
	{
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Ruolo toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
