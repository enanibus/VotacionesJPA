package votaciones.models.dao.jpa;

import votaciones.models.dao.ShoppingBasketDAO;
import votaciones.models.dao.entities.ShoppingBasket;

public class JPAShoppingBasketDAO extends JPATransactionGenericDAO<ShoppingBasket, Integer> implements ShoppingBasketDAO {

	public JPAShoppingBasketDAO() {
		super(ShoppingBasket.class);
	}

}
