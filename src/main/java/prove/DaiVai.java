package prove;

import model.dao.PlayerDAO;
import org.hibernate.Session;
import utility.HibernateUtil;

public class DaiVai
{
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		PlayerDAO dao = new PlayerDAO(session);



	}
}
