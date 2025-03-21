package model.dao;

import model.entities.Arbitro;
import utility.exceptions.ObjectNotFoundException;
import org.hibernate.Session;

import java.util.List;

public class ArbitroDAO
{
	private Session session;

	public ArbitroDAO(Session session)
	{
		this.session = session;
	}

	public Arbitro findById(Long id)
	{
		session.beginTransaction();
		Arbitro res = session.get(Arbitro.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Arbitro> findAll()
	{
		session.beginTransaction();
		List<Arbitro> res = session.createQuery("SELECT a FROM Arbitro a", Arbitro.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Arbitro a)
	{
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Arbitro toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
