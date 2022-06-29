<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomeAdmin.css">
</head>
<body>
 <div class="div1">
  <div class="div2">
   <h3 style="color:#e60000;text-align:center">1849 TEAM</h3>
    <div style="margin:0px 10px 0px 10px;background-color:#ac00e6;">
     <a href="#"><img style="width:18px;height:18px;float:left" src="${pageContext.request.contextPath}/image/windows.jpg"></a>
      <a href="#" style="margin-left:20px;color:white;text-decoration:none">Dashboard</a>
     </div>
     <div style="margin:10px 10px 0px 10px;background-color:#008ae6;">
      <a href="#"><img style="width:18px;height:18px;float:left" src="${pageContext.request.contextPath}/image/admin2.jpg"></a>
       <a href="#" style="margin-left:10px;color:white;text-decoration:none">Staff Manager</a>
     </div>
  </div>
  <div class="div3">
   <div style="position:relative">
    <img style="width:100%;height:400px" src="${pageContext.request.contextPath}/image/paris.jpg">
    <div class="divlogout"><a class="a1" href="LogoutServlet">Log out</a></div>
   </div>
   <div class="div4">
    <div class="div5"><p style="margin-left:10px">Members of the team</p></div>
    <div class="div6">
     <p class="p1">ID</p>
     <p class="p2">Name</p>
     <p class="p3">Student ID</p>
     <p class="p3">Class</p>
     <hr>
     <p class="p1">1</p>
     <p class="p2">Member 1</p>
     <p class="p4">Member Code 1</p>
     <p class="p5">Class 1</p>
     <hr>
     <p class="p1">2</p>
     <p class="p2">Member 2</p>
     <p class="p4">Member Code 2</p>
     <p class="p5">Class 2</p>
    </div>
   </div> 
  </div>  
 </div>
 
 
 
 
 
 
</body>
</html>