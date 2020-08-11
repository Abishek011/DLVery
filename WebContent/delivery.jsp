<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
<meta charset="ISO-8859-1">
<title>Delivery</title>
<link rel="stylesheet" type="text/css" href="delivery.css">
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
<script type="text/javascript" >
$(".js-example-tags").select({
	  tags: true
	});
</script>
</head>
<body >
	<a href="log.jsp" class = "gets btn btn-danger" style="text-align: center;" >Log Out</a>
 <div class="container">
        <nav class="menu navbar navbar-default">
            <ul class="main-menu">
                <li class="active"><i class="fa fa-home"></i>Delivery</li>
                <li class="with-submenu">
     
<!--                     <button onclick="location.href = 'show.jsp';" style="color: white" class="fa fa-briefcase">Show-by</button><i class="fa fa-caret-down"></i> -->
                     <form action="show" method="post">
                     <div class="box">
						  <select name="using" onchange="this.form.submit()">
						  	<option value="" class="fa fa-briefcase">Show-by</option>
						    <option value="category">Product Category</option>
						    <option value="Product_condition">Condition</option>
<!-- 						    <option value="notdamaged">Not Damaged</option> -->
						    <option value="Perishable">Perishable</option>
						    <option value="Product_expdate">Expiry Data</option>
						  </select>
					</div>              
					</form>       
                </li>
                
                <li ><form action="view" method="post"><button type="submit" class="fa fa-search" style="color:white">View All</button></form></li>
                
                <li ><form action="search_product" method="post"><button type="submit" class="fa fa-search" style="color:white">Search</button></form></li>
                
            </ul>
        </nav>
        <article>
           
            <div class="content">
                <div class="container-contact100">
		<div class="wrap-contact100">
		<form action="<%= request.getContextPath() %>/product_output" class="contact100-form" method="post">
				<h1><span class="contact100-form-title">
					Delivery
				</span>
				</h1>
				<div class="wrap-input100 bg1 contact100-form-title" data-validate="Please Type Your Name">
				<h3 style="size:10px; color:black" >
					Select Product
				</h3>
				<select class="form-control" onchange="this.form.submit()">
				  <option selected="selected">Product...</option>
				  
				</select>
				</div>
				
					
		</form>
			</div>
	</div>
                
            </div>
        </article>
    </div>
</body>
</html>