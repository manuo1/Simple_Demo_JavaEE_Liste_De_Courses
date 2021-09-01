package gestion_listes_courses.bo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

	//--------------------------------------------------------------------------
	// Attributes
	//--------------------------------------------------------------------------
	private int id;
	private String name;
	private List<Item> itemsList = new ArrayList<Item>();

	//--------------------------------------------------------------------------
	// Constructors
	//--------------------------------------------------------------------------
	public ShoppingList() {
	}
	public ShoppingList(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ShoppingList(String name) {
		super();
		this.name = name;
	}
	
	//--------------------------------------------------------------------------
	// Getters
	//--------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}
	
	//--------------------------------------------------------------------------
	// Setters
	//--------------------------------------------------------------------------
	public void setId(int id) {
	this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	
	//--------------------------------------------------------------------------
	// toString
	//--------------------------------------------------------------------------
	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", name=" + name + ", itemsList=" + itemsList + "]";
	}
	
	
	
}
