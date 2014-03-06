package votaciones.models.dao.jpa;

import votaciones.models.dao.ProductDAO;
import votaciones.models.dao.entities.Product;

public class JPAProductDAO extends JPATransactionGenericDAO<Product, Integer> implements ProductDAO {

	public JPAProductDAO() {
		super(Product.class);
	}

}
