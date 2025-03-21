package model.dao;

import model.entities.Arbitro;
import model.entities.Player;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class PlayerDAO
{
	private Session session;

	public PlayerDAO(Session session)
	{
		this.session = session;
	}

	public Player findById(Long id)
	{
		session.beginTransaction();
		Player res = session.get(Player.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Player> findAll()
	{
		session.beginTransaction();
		List<Player> res = session.createQuery("SELECT p FROM Player p", Player.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Player p)
	{
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Player toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
