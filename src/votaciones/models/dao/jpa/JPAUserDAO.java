package votaciones.models.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.UserDAO;
import votaciones.models.dao.UserDetailDAO;
import votaciones.models.dao.entities.User;
import votaciones.models.dao.entities.UserDetail;

public class JPAUserDAO extends JPATransactionGenericDAO<User, Integer> implements UserDAO {

	public JPAUserDAO() {
		super(User.class);
	}

	// Si user.userDetail pasa a null,
	// se debe borrar la instancia de UserDetail
	@Override
	public void update(User entity) {
		this.em.getTransaction().begin();
		try {
			this.em.merge(entity);
			if (entity.getDetail() == null) {
				UserDetailDAO udDAO = DAOFactory.getFactory().getUserDetailDAO();
				UserDetail ud = udDAO.findByUserId(entity.getId());
				if (ud != null) udDAO.delete(ud);
			}
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAUserDAO:update: " + e);
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getByLevel(int level) {
		Query query = em.createNamedQuery("getByLevel");
		query.setParameter("level", level);
		List<?> res = query.getResultList();
		return (List<User>) res;
	}

}
