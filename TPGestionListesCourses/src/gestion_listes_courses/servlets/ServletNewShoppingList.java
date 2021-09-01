package gestion_listes_courses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion_listes_courses.bll.ShoppingListManager;
import gestion_listes_courses.bo.ShoppingList;

/**
 * Servlet implementation class ServletNewShoppingList
 */
@WebServlet("/new_shopping_list")
public class ServletNewShoppingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		ShoppingListManager shoppingListManager = new ShoppingListManager();
 		
 		// check if user want to delete an item from the list
 		if (request.getParameter("delete_item_with_id") != null) {
 			// delete the item
 			int id_of_the_item_to_delete = Integer.parseInt(request.getParameter("delete_item_with_id"));
 			shoppingListManager.deleteItem(id_of_the_item_to_delete);
 			// get the updated shopping list
 		    int actual_shopping_list_id = Integer.parseInt(request.getParameter("actual_shopping_list_id"));  
 		    ShoppingList updatedShoppingList = shoppingListManager.getShoppingListById(actual_shopping_list_id);
			// add the updated shopping list to the request
 		   request.setAttribute("shoppingList", updatedShoppingList);
 		}
 		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/new_shopping_list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShoppingListManager shoppingListManager = new ShoppingListManager();
		String new_shopping_list_name = request.getParameter("new_shopping_list_name");
		String new_article_name = request.getParameter("new_article_name");
		// try to get a shopping list in database with the same name
		int shopping_list_id = shoppingListManager.getShoppingListIdByName(new_shopping_list_name);
		// if there is no shopping list in database, add a new one
		if(shopping_list_id==0) {
			shopping_list_id = shoppingListManager.insertShoppingList(new_shopping_list_name);
		}
		// add the new item to the shopping list
		shoppingListManager.insertItem(new_article_name, shopping_list_id);
		// get the updated shopping list
		ShoppingList updatedShoppingList = shoppingListManager.getShoppingListById(shopping_list_id);
		request.setAttribute("shoppingList", updatedShoppingList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/new_shopping_list.jsp");
		rd.forward(request, response);
	}

}
