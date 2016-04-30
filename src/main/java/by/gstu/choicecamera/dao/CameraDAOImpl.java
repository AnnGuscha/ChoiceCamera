package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Camera;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CameraDAOImpl implements CameraDAO {

	protected static Logger logger = Logger.getLogger("main/java/by/gstu/choicecamera/dao");
	@Autowired
	private SessionFactory sessionFactory;

	public CameraDAOImpl() {
	}

	public void add(Camera camera) {
		logger.debug("Adding new camera");
		sessionFactory.getCurrentSession().save(camera);
	}

	@SuppressWarnings("unchecked")
	public List<Camera> list() {

		logger.debug("Retrieving all cameras");
		return sessionFactory.getCurrentSession().createQuery("from Camera")
			.list();
	}

	public void remove(Integer id) {
		logger.debug("Deleting existing camera");
		Camera camera = (Camera) sessionFactory.getCurrentSession().load(
				Camera.class, id);
		if (null != camera) {
			sessionFactory.getCurrentSession().delete(camera);
		}
	}

	public Camera get(Integer id)
	{
		return (Camera) sessionFactory.getCurrentSession().get(Camera.class, id);
	}

	public void edit(Camera camera) {
		logger.debug("Editing existing camera");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing camera via id
		Camera existingCamera = (Camera) session.get(Camera.class, camera.getId());

		// Assign updated values to this camera
		existingCamera.setName(camera.getName());
		existingCamera.setManufacturer(camera.getManufacturer());
		existingCamera.setPrice(camera.getPrice());
		existingCamera.setMatrixDot(camera.getMatrixDot());
		existingCamera.setApertureMin(camera.getApertureMin());
		existingCamera.setApertureMax(camera.getApertureMax());
		existingCamera.setReleaseDate(camera.getReleaseDate());

		// Save updates
		session.save(existingCamera);
	}
}
