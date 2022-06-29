<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/LoginAdmin.css">
</head>
<body>
<div class="flex-container">
 <div class="flex-right">
  <div class="div2">
   <h1 style="font-family:Times New Roman;font-size:50px">Sign in</h2>
   <form action="LoginServlet" method="post" style="text-align:center">
    <label style="font-size:25px" for="email">Email</label></br>
    <input style="height:25px" type="text" id="email" name="email" placeholder="Enter Email" required><br>
    <label style="font-size:25px" for ="password">Password</label></br>
    <input style="height:25px" type="password" id="password" name="password" placeholder="Enter Password" required><br>
    <input type="submit" class="ip" value="LOGIN">
   </form>
    <div style="margin:6px">
     <label for="remember">Remember me</label>
     <input type="checkbox" id="remember" name="remember" value="true">
    </div>
    <div style="margin:6px"><a href="#" style="text-decoration:none;"><center>Forgot password?</center></a></div>
    <p style="color:red"><%
    		if(session.getAttribute("error") != null)
    		{
    		out.println(session.getAttribute("error"));
    		session.removeAttribute("error");
    		} 
    		%>
    </p>
   </div> 
  </div>
 <div class="flex-left">
  <div class="div1">
  <h1 style="color:white;font-size:50px">Welcome Back!</h1>
   <p style="color:white;font-size:30px">To keep connected with us please login with your personal info</p>
  </div>
 </div>
</div>


</body>
</html>