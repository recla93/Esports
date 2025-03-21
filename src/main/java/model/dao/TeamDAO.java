package model.dao;

import model.entities.Ruolo;
import model.entities.Team;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class TeamDAO
{
	private Session session;

	public TeamDAO(Session session)
	{
		this.session = session;
	}

	public Team findById(Long id)
	{
		session.beginTransaction();
		Team res = session.get(Team.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Team> findAll()
	{
		session.beginTransaction();
		List<Team> res = session.createQuery("SELECT t FROM Team t", Team.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Team t)
	{
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Team toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
