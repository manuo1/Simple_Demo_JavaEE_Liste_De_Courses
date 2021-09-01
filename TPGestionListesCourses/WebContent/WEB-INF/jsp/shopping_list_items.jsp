<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ include file="../common_html/start_of_html_page.html" %>


<div class="card-header fs-3">Courses<hr>
	<div class="fs-5">Votre Pannier</div>
	<div class="text-muted fs-5">${shoppingList.name}</div>
</div>

<div class="card-body overflow-auto">
	<p class="card-text">

			<c:forEach var="item" items="${shoppingList.itemsList}">
				<div class="form-check fs-3">
				  <input 	class="form-check-input"
				  			type="checkbox" 
				  			value="" 
				  			id="flexCheckDefault" 
				  			<c:if test="${item.checked == true}">checked</c:if>
				  			onchange="window.location.href='${pageContext.request.contextPath}/shopping_list_items?shopping_list_id=${shoppingList.id}&change_item_with_id=${item.id}'">
				  <label class="form-check-label <c:if test="${item.checked == true}">text-decoration-line-through</c:if>" for="flexCheckDefault">
				    ${item.name}
				  </label>
				  
				</div>
			</c:forEach>	
	</p>
</div>
<div class="card-footer">
	<div class="row">
		<div class="col-6">
			<a href="${pageContext.request.contextPath}/index" class="fs-1"><i class="bi bi-arrow-left-circle-fill"></i></a>
		</div>
		<div class="col-6">
			<a href="${pageContext.request.contextPath}/shopping_list_items?shopping_list_id=${shoppingList.id}&uncheck_all=${shoppingList.id}" class="fs-1"><i class="bi bi-eraser-fill"></i></a>
		</div>
	</div>
</div>


<%@ include file="../common_html/end_of_html_page.html" %>