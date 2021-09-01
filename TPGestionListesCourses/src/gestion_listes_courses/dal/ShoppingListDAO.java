package gestion_listes_courses.dal;

import java.util.List;

import gestion_listes_courses.bo.Item;
import gestion_listes_courses.bo.ShoppingList;

public interface ShoppingListDAO {
	// methods for ShoppingList
	public int insertShoppingList(String shoppingListName);
	public void deleteShoppingList(int id);
	public List<ShoppingList> selectAllShoppingList();
	public ShoppingList selectShoppingListById(int id);
	public int getShoppingListIdByName(String name);
	
	// methods for Items
	public void insertItem(String name, int id_shopping_list);
	public Item selectItemById(int id);
	public void deleteItem(int id);
	public void checkItem(int id);
	public void uncheckItem(int id);
	public void uncheckAllShoppingListItem(int id_shopping_list);
}
