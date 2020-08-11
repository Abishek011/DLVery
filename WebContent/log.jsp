<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<title>Login / Register</title>
	<link rel="icon" type="image/x-icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="sign.css">
    
</head>

<body style="background-image: url('bg-masthead.jpg')">
	<div class="hero">
		 <div class="registerform">
			
			<div class="button">
				<div id="btn"></div>

				
				<button type="button" class="toggle"  onclick="login()">Log In</button>
                <button type="button" class="toggle" onclick="register()">Sign Up</button><br>
			</div>

			<!-- <div class="social">
                <img src="https://i.pinimg.com/originals/19/c3/e9/19c3e9c4491976bf05939c530486be23.jpg">
                </div>
			 -->
			 	
			 	<form action="<%= request.getContextPath() %>/login" method="post" id="login" class="form" name="myform"  method="post"> 
				<input type="text" name="userid" class="input" placeholder="Username"  required>
				<input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" class="input" placeholder="Password" required title="Required field">
				<br><br>
				<button type="submit" class="btn">Login</button>
				<br><br>
				<p style="color:red;font-size:small;">*If New user please Register Your Account...</p> 
			</form>
			
			<form  action="<%= request.getContextPath() %>/register" method="post" id="register" class="form"> 
				<p style="color:red">*All fields are required</p>
				<input type="text" name="username" class="input" placeholder="Username" required>
				<input type="date" name="dob" class="input" placeholder="Date of Birth" required>
				<input type="email" name="email" class="input" placeholder="Email Id" required>
				<input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" class="input" placeholder="Password" required title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
<!-- 				<input type="password" name="confirmpassword" pattern=".{8,25}" class="input" placeholder="Confirm Password" required title="Must be between 8 to 25"> -->
				<button type="submit" class="btn"  name='reg_user'>Sign up</button>
			</form>

		</div>
	</div>

	<script type="text/javascript">
		
		function register()
		{
			var x=document.getElementById("login");
			var y=document.getElementById("register");
			var z=document.getElementById("btn");
			 x.style.left="-400px";
			 y.style.left="50px";
			 z.style.left="110px";
		}

		function login()
		{
			var x=document.getElementById("login");
			var y=document.getElementById("register");
			var z=document.getElementById("btn");
			x.style.left="50px";
			y.style.left="450px";
			z.style.left="0";
		}

	
	</script>
	
	</body>
</html>