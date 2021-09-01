package gestion_listes_courses.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion_listes_courses.bll.ShoppingListManager;
import gestion_listes_courses.bo.ShoppingList;

/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingListManager shoppingListManager = new ShoppingListManager();
		List<ShoppingList> allShoppingLists=null;
		
		// check if user want to delete a shopping list
		if(request.getParameter("delete_shopping_list")!=null) {
			int shopping_list_id = Integer.parseInt(request.getParameter("delete_shopping_list"));
			shoppingListManager.deleteShoppingList(shopping_list_id);
		}
		
		// send all the shopping list to the servlet
		allShoppingLists = shoppingListManager.getAllShoppingList();
 		request.setAttribute("allShoppingLists", allShoppingLists);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
