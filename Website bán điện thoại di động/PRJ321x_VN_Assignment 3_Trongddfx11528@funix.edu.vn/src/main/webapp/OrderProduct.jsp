<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Cart" %>
<%@page import="java.util.List" %> 
<%@page import="model.ProductOrders" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
<%@ include file="header.jsp" %>
<form action="SaveCartToDB" method="post">
<table style="width:75%;margin-top:15px" border="1">
 <tr>
  <th>Product Name</th>
  <th>Price</th>
  <th>Quantity</th>
  <th>TotalPrice</th>
 </tr>
 <%
   Cart cart = (Cart) session.getAttribute("giohang");
  if (cart != null) { 
	  List<ProductOrders> pds = cart.getItems();
      double tt = cart.getAmount();
      request.setAttribute("gio",pds);
      request.setAttribute("tongtien",tt); 
     // for(ProductOrders o: pds) { 
    	 
	  %>
	  
	   <c:forEach items="${gio}" var="o">
	    <tr>
	     <td><c:out value="${o.getNameProduct()}"/></td>
	     <td><c:out value="${o.getPrice()}"/></td>
	     <td><c:out value="${o.getAmountProduct()}"/></td>
	     <td><c:out value="${o.getTotalprice()}"/></td>
        </tr> 
	   </c:forEach>
        <tr style="border:none">
         <th style="border:none"></th>  
         <th style="border:none"></th>  
         <th style="border:none"></th>  
         <th style="border:none">TotalPriceCart: <c:out value="${tongtien}"/></th>
        </tr>
	 <%  
  }
%>
  
</table>
<br>
<label for="na">Họ tên khách hàng</label>
<input type="text" id="na" name="name" placeholder="enter name" required><br><br>
<label for="ad">Địa chỉ</label>
<input type="text" id="ad" name="address" placeholder="enter address" required><br><br>
<label for="pn">Số điện thoại</label>
<input type="text" id="pn" name="phone number" placeholder="enter phone number" required><br>
<input type="submit" value="Submit">
</form>
</body>
</html>