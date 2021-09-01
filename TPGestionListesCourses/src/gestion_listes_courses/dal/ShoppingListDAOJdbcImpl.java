package gestion_listes_courses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestion_listes_courses.bo.Item;
import gestion_listes_courses.bo.ShoppingList;

public class ShoppingListDAOJdbcImpl implements ShoppingListDAO{

	// #####################################################################################################################################
	// SQL Queries -------------------------------------------------------------------------------------------------------------------------
	// #####################################################################################################################################
	private static final String INSERT_SHOPPING_LIST = "INSERT INTO SHOPPING_LISTS(name) VALUES(?)";
	private static final String DELETE_SHOPPING_LIST = "DELETE FROM SHOPPING_LISTS WHERE id=?";
	private static final String SELECT_ALL_SHOPPING_LIST = "SELECT id, name FROM SHOPPING_LISTS";
	private static final String SELECT_SHOPPING_LIST_BY_ID = 	"SELECT "+
																"SHOPPING_LISTS.id as id_shopping_list, "+
																"SHOPPING_LISTS.name as name_shopping_list, "+
																"ITEMS.id as id_item, "+
																"ITEMS.name as name_item, "+
																"ITEMS.checked "+
																"FROM SHOPPING_LISTS LEFT JOIN ITEMS ON SHOPPING_LISTS.id = ITEMS.id_shopping_list "+
																"WHERE SHOPPING_LISTS.id=?";
	private static final String SELECT_SHOPPING_LIST_BY_NAME = 	"SELECT id FROM SHOPPING_LISTS WHERE name=?";

	private static final String INSERT_ITEM = "INSERT INTO ITEMS(name, id_shopping_list) VALUES(?,?)";
	private static final String SELECT_ITEM_BY_ID = "SELECT id, name, checked FROM ITEMS WHERE id=?";
	private static final String DELETE_ITEM = "DELETE FROM ITEMS WHERE id=?";
	private static final String UPDATE_CHECK_ITEM = "UPDATE ITEMS SET checked=1 WHERE id=?";
	private static final String UPDATE_UNCHECK_ITEM ="UPDATE ITEMS SET checked=0 WHERE id=?";
	private static final String UPDATE_UNCHECK_ALL_SHOPPING_LIST_ITEMS="UPDATE ITEMS SET checked=0 WHERE id_shopping_list=?";
	
	// #####################################################################################################################################
	// methods for ShoppingList ------------------------------------------------------------------------------------------------------------
	// #####################################################################################################################################
	
	public int insertShoppingList(String shoppingListName){
		int new_id = 0;
		try(Connection connection = DataBaseConnection.getConnection())
		{
			try {
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_SHOPPING_LIST, PreparedStatement.RETURN_GENERATED_KEYS);
					preparedstatement.setString(1, shoppingListName);
					preparedstatement.executeUpdate();
					ResultSet resultSet = preparedstatement.getGeneratedKeys();
					// get the new id
					if(resultSet.next())
					{
						new_id = resultSet.getInt(1);
					}
				} catch (Exception e) {
					// Catch insertions exceptions
					e.printStackTrace();
				}
		}
		catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}
	
		return new_id;	
	}
	
	public void deleteShoppingList(int id) {
		
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(DELETE_SHOPPING_LIST);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}		

	}
	
	public List<ShoppingList> selectAllShoppingList() {
		
		List<ShoppingList> shoppingList = new ArrayList<ShoppingList>();
		
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ALL_SHOPPING_LIST);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next())
			{
				shoppingList.add(new ShoppingList(resultset.getInt("id"), resultset.getString("name")));
			}
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}	
		return shoppingList;		
	}
	
	public ShoppingList selectShoppingListById(int id) {
		
		ShoppingList shoppinglist = new ShoppingList();
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(SELECT_SHOPPING_LIST_BY_ID);
			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				shoppinglist.setId(resultset.getInt("id_shopping_list"));
				shoppinglist.setName(resultset.getString("name_shopping_list"));
				// if shopping list have items add them to the shopping list item list
				if(resultset.getString("id_item")!=null)
				{
					Item item = new Item(resultset.getInt("id_item"), resultset.getString("name_item"), resultset.getBoolean("checked"));
					shoppinglist.getItemsList().add(item);
				}
			}
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}	
		
		return shoppinglist;		
	}
	
		public int getShoppingListIdByName(String name) {
			int id=0;
			try(Connection connection = DataBaseConnection.getConnection())
			{
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT_SHOPPING_LIST_BY_NAME);
				preparedstatement.setString(1, name);
				ResultSet resultset = preparedstatement.executeQuery();
				while(resultset.next()) {
					id = resultset.getInt("id");
				}
			} catch (SQLException e) {
				// Catch connections exceptions
				e.printStackTrace();
			}	
			
			return id;			
		}
	
	
	// #####################################################################################################################################
	// methods for Items -------------------------------------------------------------------------------------------------------------------
	// #####################################################################################################################################
	
		public void insertItem(String name, int id_shopping_list){
			int new_id = 0;
			try(Connection connection = DataBaseConnection.getConnection())
			{
				try {
					PreparedStatement preparedstatement = connection.prepareStatement(INSERT_ITEM);
						preparedstatement.setString(1, name);
						preparedstatement.setInt(2, id_shopping_list);
						preparedstatement.executeUpdate();
					} catch (Exception e) {
						// Catch insertions exceptions
						e.printStackTrace();
					}
			}
			catch (SQLException e) {
				// Catch connections exceptions
				e.printStackTrace();
			}
		
		}
		public Item selectItemById(int id) {
			
			Item item = new Item();
			try(Connection connection = DataBaseConnection.getConnection())
			{
				PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ITEM_BY_ID);
				preparedstatement.setInt(1, id);
				ResultSet resultset = preparedstatement.executeQuery();
				while(resultset.next()) {
					item.setId(resultset.getInt("id"));
					item.setName(resultset.getString("name"));
					item.setChecked(resultset.getBoolean("checked"));
				}
			} catch (SQLException e) {
				// Catch connections exceptions
				e.printStackTrace();
			}	
			
			return item;		
			
		}
		public void deleteItem(int id) {
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(DELETE_ITEM);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}		
	}
	
	public void checkItem(int id) {
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(UPDATE_CHECK_ITEM);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}		
	}
	
	public void uncheckItem(int id) {
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(UPDATE_UNCHECK_ITEM);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}		
	}
	
	public void uncheckAllShoppingListItem(int id_shopping_list) {
		try(Connection connection = DataBaseConnection.getConnection())
		{
			PreparedStatement preparedstatement = connection.prepareStatement(UPDATE_UNCHECK_ALL_SHOPPING_LIST_ITEMS);
			preparedstatement.setInt(1, id_shopping_list);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// Catch connections exceptions
			e.printStackTrace();
		}		
	}
	
	
	
}
