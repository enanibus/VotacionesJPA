package votaciones.models.dao.jpa;

import votaciones.models.dao.UserDetailDAO;
import votaciones.models.dao.entities.UserDetail;

public class JPAUserDetailDAO extends JPATransactionGenericDAO<UserDetail, Integer> implements UserDetailDAO {

	public JPAUserDetailDAO() {
		super(UserDetail.class);
	}

	@Override
	public UserDetail findByUserId(int userId) {
		String jpql = "SELECT ud FROM UserDetail ud WHERE ud.user.id = " + userId;
		UserDetail ud = (UserDetail) em.createQuery(jpql).getSingleResult();
		return ud;
	}

}
