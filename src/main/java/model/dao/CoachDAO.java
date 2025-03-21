package model.dao;

import model.entities.Coach;
import model.entities.Player;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class CoachDAO
{
	private Session session;

	public CoachDAO(Session session)
	{
		this.session = session;
	}

	public Coach findById(Long id)
	{
		session.beginTransaction();
		Coach res = session.get(Coach.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Coach> findAll()
	{
		session.beginTransaction();
		List<Coach> res = session.createQuery("SELECT c FROM Coach c", Coach.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Coach c)
	{
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Coach toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
