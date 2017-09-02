<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Bebidas">
	<h1>Bebidas</h1>
	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			<th>Preço</th>
		</tr>
		<c:forEach items="${bebidas }" var="b">
			<tr>
				<td>${b.nome }</td>
				<td>${b.preco }</td>
			</tr>
		</c:forEach>
	</table>
</tag:template>