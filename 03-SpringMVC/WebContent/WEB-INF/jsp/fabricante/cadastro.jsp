<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Fabricante">
	<h1>Cadastro de Fabricante</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>	
	
	<c:url value="/fabricante/cadastrar" var="action"/>
	<form:form method="post" action="${action }" commandName="fabricante">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form:form>
</tag:template>

