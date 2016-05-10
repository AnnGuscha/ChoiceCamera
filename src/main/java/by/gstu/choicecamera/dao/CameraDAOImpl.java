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
//		List<Camera> cameras = new ArrayList<>();
//		Camera camera = new Camera();
//		camera.setId(1);
//		camera.setName("D3200");
//		camera.setPrice(6900000);
//		camera.setReleaseDate(2012);
//		camera.setManufacturer("Nikon");
//		camera.setApertureMin(3.5);
//		camera.setApertureMax(5.6);
//		camera.setMatrixDot(24.2);
//		cameras.add(camera);
//		Camera camera1 = new Camera();
//		camera1.setId(2);
//		camera1.setName("DMC-GX7");
//		camera1.setPrice(8999000);
//		camera1.setReleaseDate(2013);
//		camera1.setManufacturer("Panasonic");
//		camera1.setApertureMin(3.5);
//		camera1.setApertureMax(5.6);
//		camera1.setMatrixDot(16.0);
//		cameras.add(camera1);
//		Camera camera2 = new Camera();
//		camera2.setId(3);
//		camera2.setName("X20");
//		camera2.setPrice(7499000);
//		camera2.setReleaseDate(2013);
//		camera2.setManufacturer("Fujifilm");
//		camera2.setApertureMin(2.0);
//		camera2.setApertureMax(2.8);
//		camera2.setMatrixDot(12.0);
//		cameras.add(camera2);
//		Camera camera3 = new Camera();
//		camera3.setId(4);
//		camera3.setName("EOS 1200D");
//		camera3.setPrice(6600000);
//		camera3.setReleaseDate(2014);
//		camera3.setManufacturer("Canon");
//		camera3.setApertureMin(3.5);
//		camera3.setApertureMax(5.6);
//		camera3.setMatrixDot(18.0);
//		cameras.add(camera3);
//		return cameras;
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
