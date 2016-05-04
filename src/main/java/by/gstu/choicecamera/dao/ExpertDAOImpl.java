package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

	protected static Logger logger = Logger.getLogger("main/java/by/gstu/choicecamera/dao");
	@Autowired
	private SessionFactory sessionFactory;

	public ExpertDAOImpl() {
	}

	public void add(Expert expert) {
		logger.debug("Adding new expert");
		sessionFactory.getCurrentSession().save(expert);
	}

	@SuppressWarnings("unchecked")
	public List<Expert> list() {

		logger.debug("Retrieving all experts");
		return sessionFactory.getCurrentSession().createQuery("from Expert")
			.list();
	}

	public void remove(Integer id) {
		logger.debug("Deleting existing expert");
		Expert expert = (Expert) sessionFactory.getCurrentSession().load(
				Expert.class, id);
		if (null != expert) {
			sessionFactory.getCurrentSession().delete(expert);
		}
	}

	public Expert get(Integer id)
	{
		Expert expert = (Expert) sessionFactory.getCurrentSession().get(Expert.class, id);
		return expert;
	}

	public Expert get(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Expert where user=:userId");
		query.setParameter("userId", user.getId());
		Expert expert = (Expert) query.list().get(0);
		return expert;
	}

	public void edit(Expert expert) {
		logger.debug("Editing existing expert");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing expert via id
		Expert existingExpert = (Expert) session.get(Expert.class, expert.getId());

		// Assign updated values to this expert
		existingExpert.setName(expert.getName());
		existingExpert.setUser(expert.getUser());
		existingExpert.setMarkPrice(expert.getMarkPrice());
		existingExpert.setMarkDate(expert.getMarkDate());
		existingExpert.setMarkManufacturer(expert.getMarkManufacturer());
		existingExpert.setMarkAperture(expert.getMarkAperture());
		existingExpert.setMarkMatrixDot(expert.getMarkMatrixDot());
		existingExpert.setManufacturersMarks(expert.getManufacturersMarks());

		// Save updates
		session.save(existingExpert);
	}
}
