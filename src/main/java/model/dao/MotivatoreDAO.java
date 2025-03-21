package model.dao;

import model.entities.Lobby;
import model.entities.Motivatore;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class MotivatoreDAO
{

	private Session session;

	public MotivatoreDAO(Session session)
	{
		this.session = session;
	}

	public Motivatore findById(Long id)
	{
		session.beginTransaction();
		Motivatore res = session.get(Motivatore.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Motivatore> findAll()
	{
		session.beginTransaction();
		List<Motivatore> res = session.createQuery("SELECT m FROM Motivatore m", Motivatore.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Motivatore m)
	{
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Motivatore toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
