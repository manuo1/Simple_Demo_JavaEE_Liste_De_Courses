<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ include file="../common_html/start_of_html_page.html" %>

<div class="card-header fs-3">Courses<hr>
	<div class="fs-4 text-muted">Nouvelle liste</div>
</div>
<form method="post" action="new_shopping_list">	
	<div class="card-body">
		<div class="card-text">
			<!-- Shopping list Name -->
			<div style="height: 5rem">
				<input type="text" class="form-control" id="shopping_list_name" name="new_shopping_list_name" 
					placeholder="Nom de la liste de courses" required 
					<c:if test="${!empty shoppingList.name}">
						value="${shoppingList.name}"
						readonly
					</c:if>
					>
			</div>
			
			<!-- Items zone -->
			<div style="height: 15rem" class="container overflow-auto">
			
			<c:forEach var="item" items="${shoppingList.itemsList}">
			<div class="row align-middle">
			
			<!-- Item name -->
				<div class="col-8 text-start fs-4 ">${item.name}</div>
			<!-- Delete Item -->
				<div class="col-4 text-center">
					<a href="${pageContext.request.contextPath}/new_shopping_list?delete_item_with_id=${item.id}&actual_shopping_list_id=${shoppingList.id}" class="fs-3"><i class="bi bi-x-octagon-fill"></i></a>
				</div>
			</div>				
			</c:forEach>
			</div>
			</div>
			
			<!-- Add new item -->
			<div style="height: 5rem">
				<div class="row px-4">
					<div class="col-10 pt-4"><input type="text" class="form-control" id="new_article_name" name="new_article_name" placeholder="Nouvel Article" required></div>
					<div class="col-2 pt-1"><button type="submit" class="fs-1 btn btn-link"><i class="bi bi-plus-circle-fill"></i></button ></div>
				</div>
			</div>
		</div>
	
</form>	
<div class="card-footer">
	<div class="row">
		<div class="col-6">
			
		</div>
		<div class="col-6">
			<a href="index" class="fs-1"><i class="bi bi-arrow-right-circle-fill"></i></a>
		</div>
	</div>
</div>


<%@ include file="../common_html/end_of_html_page.html" %>