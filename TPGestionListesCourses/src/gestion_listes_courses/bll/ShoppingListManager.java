package gestion_listes_courses.bll;

import gestion_listes_courses.dal.ShoppingListDAO;

import java.util.List;

import gestion_listes_courses.bo.Item;
import gestion_listes_courses.bo.ShoppingList;
import gestion_listes_courses.dal.DAOFactory;

public class ShoppingListManager {

	//--------------------------------------------------------------------------
	// Attributes
	//--------------------------------------------------------------------------
	private ShoppingListDAO shoppingListDAO;

	//--------------------------------------------------------------------------
	// Constructors
	//--------------------------------------------------------------------------
	public ShoppingListManager() {
		this.shoppingListDAO=DAOFactory.getShoppingListDAO();
	}
	
	//--------------------------------------------------------------------------
	// Methods for Shopping List
	//--------------------------------------------------------------------------
	public int insertShoppingList(String shoppingListName){
		return this.shoppingListDAO.insertShoppingList(shoppingListName);
	}
	
	public void deleteShoppingList(int id) {
		this.shoppingListDAO.deleteShoppingList(id);
	}
	
	public List<ShoppingList> getAllShoppingList(){
		return this.shoppingListDAO.selectAllShoppingList();
	}
	
	public ShoppingList getShoppingListById(int id){
		return this.shoppingListDAO.selectShoppingListById(id);
	}

	public int getShoppingListIdByName(String name){
		return this.shoppingListDAO.getShoppingListIdByName(name);
	}

	//--------------------------------------------------------------------------
	// methods for Items
	//--------------------------------------------------------------------------
	public void insertItem(String name, int id_shopping_list) {
		this.shoppingListDAO.insertItem(name, id_shopping_list);
	}

	public Item getItemById(int id){
		return this.shoppingListDAO.selectItemById(id);
	}
	
	public void deleteItem(int id) {
		this.shoppingListDAO.deleteItem(id);
	}
	
	public void checkItem(int id) {
		this.shoppingListDAO.checkItem(id);
	}
	
	public void uncheckItem(int id) {
		this.shoppingListDAO.uncheckItem(id);
	}
	
	public void uncheckAllShoppingListItem(int id_shopping_list) {
		this.shoppingListDAO.uncheckAllShoppingListItem(id_shopping_list);
	}

}
