<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ include file="Header.jsp" %>


<h2 align="center">Product Page</h2>
<form:form  action="InsertProduct" modelAttribute="product" method="post">


<table align="center">
  <tr>
<td colspan="2"><center>Product Form</center></td></tr>
<tr>
 <td>ProductName</td>
 <td><form:input type="text" path="productId"/></td>
 </tr>
 <tr>
 <tr>
 <td>ProductDesc</td>
 <td><form:input  type="text" path="productDesc"/></td>
 </tr>

 
 <td>Price</td>
 <td><form:input type="text" path="price"/></td>
 </tr>

<tr>
 <td>Stock</td>
 <td><form:input type="text"  path="stock"/></td>
 </tr>
 <tr>
 <td>CategoryId</td>
 <td>
 <form:select  type="text"  path="categoryId">
     <form:option value="0" label="---select--"/>
     <form:options items="${categoryList}"/>
     </form:select>
</td>     
 </tr>
 <tr>
 <td>SupplierId</td>
 <td><form:input type="text"  path="supplierId"/></td>
 </tr>
 <tr>
		<td colspan="2"><center><input type="submit" value="Insert Product"/></center></td>
	</tr>
	</table>
</form:form>	
	<table align="center" border="1">
	<tr>
	<td>ProductID</td>
	<td>ProductName</td>
	<td>ProductDesc</td>
	<td>Price</td>
	<td>Stock</td>
	<td>CategoryId</td>
	<td>SupplierId</td>
	<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>${product.categoryId}</td>
		<td>${product.supplierId}</td>
		<td>
			<a href="<c:url value="/updateCategory/${category.categoryId}"/>">Edit</a>
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	</table>

