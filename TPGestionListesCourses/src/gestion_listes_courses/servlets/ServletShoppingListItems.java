package gestion_listes_courses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion_listes_courses.bll.ShoppingListManager;
import gestion_listes_courses.bo.Item;
import gestion_listes_courses.bo.ShoppingList;

/**
 * Servlet implementation class ServletShoppingListItems
 */
@WebServlet("/shopping_list_items")
public class ServletShoppingListItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingListManager shoppingListManager = new ShoppingListManager();
		// check if user want to check an item
		if (request.getParameter("change_item_with_id") != null) {
			Item changed_item = null;
			// get the selected item
			int item_id = Integer.parseInt(request.getParameter("change_item_with_id"));
			// get the item
			changed_item = shoppingListManager.getItemById(item_id);
			if (changed_item.isChecked() == true) {	
				shoppingListManager.uncheckItem(item_id);
			}
			if (changed_item.isChecked() == false) {		
				shoppingListManager.checkItem(item_id);
			}
		}
		// check if user want to uncheck all items
		if (request.getParameter("uncheck_all") != null) {
			int item_id = Integer.parseInt(request.getParameter("uncheck_all"));
			shoppingListManager.uncheckAllShoppingListItem(item_id);
		}
		// get the selected shopping list items
		int shopping_list_id = Integer.parseInt(request.getParameter("shopping_list_id"));
		ShoppingList selectedShoppingList = shoppingListManager.getShoppingListById(shopping_list_id);
		// add the shopping list to the request
		request.setAttribute("shoppingList", selectedShoppingList);		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/shopping_list_items.jsp");
		rd.forward(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
