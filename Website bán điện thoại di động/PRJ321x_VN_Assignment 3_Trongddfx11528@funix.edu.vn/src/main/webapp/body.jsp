<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="model.Product" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 <div class="row">
  <div class="leftcolumn">
    <c:forEach items="${ListData}" var="o">
    <div class="div1">
     <a href="ProductDetail?pid=${o.id}"><img src="${o.src}"></a>     
     <div style="margin:10px"><a href="ProductDetail?pid=${o.id}" style="text-decoration:none"><b>${o.name}</b></a></div>
     <h3>${o.price}$</h3>
    </div>
   </c:forEach>
 </div>
  <div class="rightcolumn">
   <div style="background-color: #ffffe6">
    <a style="text-decoration:none;" href="OrderProduct.jsp"><h3 style="color:#4c0080">Giỏ hàng</h3></a>
    <a href="OrderProduct.jsp"><img style="width:50%;" src="${pageContext.request.contextPath}/image/giohang.jpg"></a>
   </div> 
   <div style="padding-top: 30px">
    <h3 style="color:black">Các sản phẩm nổi bật khác</h3> 
    <a href="#"><img style="width:100%;" src="${pageContext.request.contextPath}/image/oppo.jpg"></a>
    <a href="#"><img style="width:100%;" src="${pageContext.request.contextPath}/image/xiaomi.jpg"></a>
    <a href="#"><img style="width:100%;" src="${pageContext.request.contextPath}/image/vivo.jpg"></a>         
   </div>
   </div> 
 </div>
</body>
</html>