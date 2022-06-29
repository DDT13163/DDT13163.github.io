<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 <div class="header">
  <h1>Chào mừng bạn đến với Chợ Di Động!</h1>
  <p style="font-size:30px; color:#ff0000"><b>Lựa chọn hoàn hảo cho các tín đồ công nghệ!</b></p> 
 </div>

 <div class="topnav">
  <a href="LoadProductToHome">Trang chủ</a>
  <a href="#">Sản phẩm</a>
  <a href="#">Ưu đãi</a>
  <a href="LoginAdmin.jsp" style="float:right">Đăng nhập</a>
  <a href="#" style="float:right">Đăng kí</a>
  <div class="form1"> 
   <form action="SearchControl" method="post">
    <input type="text" placeholder="Bạn muốn tìm sản phẩm gì" name="timkiem">
    <button type="submit">Tìm kiếm</button>   
   </form>
  </div>   
 </div>
</body>
</html>