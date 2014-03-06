package votaciones.models.dao.jpa;

import votaciones.models.dao.entities.Category;

public class JPACategoryDAO extends JPATransactionGenericDAO<Category, Integer> implements votaciones.models.dao.CategoryDAO {
    public JPACategoryDAO() {
        super(Category.class);
    }
}
