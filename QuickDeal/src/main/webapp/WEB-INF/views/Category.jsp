<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 align="center">Category Page</h2>

<form action="<c:url value="/InsertCategory"/>" method="post">

<table align="center">
	<tr>
		<td colspan="2">Category Info</td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc"/></td>
	</tr>
	<tr>
		<td colspan="2"><center><input type="submit" value="Save Category"/></center></td>
	</tr>
	
</table>

<table align="center" border="1">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation </td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url value="/updateCategory/${category.categoryId}"/>">Edit</a>
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

</form>
