package model.dao;

import model.entities.Motivatore;
import model.entities.Rendimento;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class RendimentoDAO
{
	private Session session;

	public RendimentoDAO(Session session)
	{
		this.session = session;
	}

	public Rendimento findById(Long id)
	{
		session.beginTransaction();
		Rendimento res = session.get(Rendimento.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<Rendimento> findAll()
	{
		session.beginTransaction();
		List<Rendimento> res = session.createQuery("SELECT r FROM Rendimento r", Rendimento.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	//lui fa sia update che insert
	public void save(Rendimento r)
	{
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		session.beginTransaction();
		Rendimento toDelete =findById(id);
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
