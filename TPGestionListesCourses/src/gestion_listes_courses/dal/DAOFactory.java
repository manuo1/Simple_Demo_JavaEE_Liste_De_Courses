package gestion_listes_courses.dal;

public class DAOFactory {
	public static ShoppingListDAO getShoppingListDAO()
	{
		return new ShoppingListDAOJdbcImpl();
	}
}
