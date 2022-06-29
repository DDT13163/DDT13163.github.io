<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomeProduct.css">
</head>
<body>
 <%@ include file="header.jsp" %>
 <h3 style="color:black">${detail.name}</h3>
 <div class="divPro">
  <div class="divDetail1">
   <img src="${detail.src}">
  </div>
  <div class="divDetail2">
   <h3 style="color:red">${detail.price}$</h3>
   <p>${detail.description}</p>
   <form action="AddToCart" method="get">
   <input type="hidden" name="id" value="${detail.id}">
   <input type="submit" value="Add To Cart">
   </form>
  </div>
 </div>
 <%@ include file="footer.jsp" %>
</body>
</html>