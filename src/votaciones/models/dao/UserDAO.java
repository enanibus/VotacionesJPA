package votaciones.models.dao;

import java.util.List;

import votaciones.models.dao.entities.User;

public interface UserDAO extends TransactionGenericDAO<User, Integer> {
	public List<User> getByLevel(int level);
}
