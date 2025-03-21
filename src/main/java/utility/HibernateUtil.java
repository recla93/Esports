package utility;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Carica la configurazione da hibernate.cfg.xml
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError("Errore nella creazione della SessionFactory: " + ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
