package votaciones.models.dao;

import votaciones.models.dao.entities.UserDetail;

public interface UserDetailDAO extends TransactionGenericDAO<UserDetail, Integer> {
	public UserDetail findByUserId(int userId);
}
