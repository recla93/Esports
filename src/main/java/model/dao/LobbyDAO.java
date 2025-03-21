package model.dao;

import model.entities.Coach;
import model.entities.Lobby;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class LobbyDAO
{
	private Session session;

	public LobbyDAO(Session session)
	{
		this.session = session;
	}

	public Lobby findById(Long id)
	{
		session.beginTransaction();
		Lobby res = session.get(Lobby.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Lobby> findAll()
	{
		session.beginTransaction();
		List<Lobby> res = session.createQuery("SELECT l FROM Lobby l", Lobby.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Lobby l)
	{
		session.beginTransaction();
		session.save(l);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Lobby toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
