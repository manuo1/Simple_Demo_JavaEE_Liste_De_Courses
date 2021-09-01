<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ include file="../common_html/start_of_html_page.html" %>

<div class="card-header fs-3">Courses<hr>
	<div class="fs-4 text-muted">Listes prédefinies</div>
</div>

<div class="card-body overflow-auto">
	<p class="card-text">
	
	<!-- Display all shopping list -->
	<c:forEach var="shoppingList" items="${allShoppingLists}">
		<div class="row align-middle">
		
		
		<!-- Shopping list Name -->
			<div class="col-8 text-start fs-4 ">${shoppingList.name}</div>
		
		<!-- LInk -> Go to shopping list items -->
			<div class="col-2 text-center">
				<a href="${pageContext.request.contextPath}/shopping_list_items?shopping_list_id=${shoppingList.id}" class="fs-3"><i class="bi bi-cart-fill"></i></a>
			</div>
		<!-- Link -> Delete shopping list -->
			<div class="col-2 text-center">
				<a href="${pageContext.request.contextPath}/index?delete_shopping_list=${shoppingList.id}" class="fs-3"><i class="bi bi-x-octagon-fill"></i></a>
			</div>
			
		</div>
	</c:forEach>
	</p>
</div>
<div class="card-footer">
	<a href="new_shopping_list" class="fs-1"><i class="bi bi-plus-circle-fill"></i></a>
</div>


<%@ include file="../common_html/end_of_html_page.html" %>