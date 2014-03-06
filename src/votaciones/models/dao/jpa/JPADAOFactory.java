package votaciones.models.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import votaciones.models.dao.CategoryDAO;
import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.ProductDAO;
import votaciones.models.dao.ShoppingBasketDAO;
import votaciones.models.dao.UserDAO;
import votaciones.models.dao.UserDetailDAO;

public class JPADAOFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "jpa";

    private EntityManager em;

    public JPADAOFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public EntityManager getEm() {
        if (!em.isOpen())
            this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
                    .createEntityManager();
        return em;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new JPACategoryDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new JPAUserDAO();
    }

    @Override
    public UserDetailDAO getUserDetailDAO() {
        return new JPAUserDetailDAO();
    }

    @Override
    public ShoppingBasketDAO getShoppingBasketDAO() {
        return new JPAShoppingBasketDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new JPAProductDAO();
    }

}
