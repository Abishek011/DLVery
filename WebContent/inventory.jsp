<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
<meta charset="ISO-8859-1">
<title>Inventory</title>
<link rel="stylesheet" type="text/css" href="inventory.css">
</head>
<body >
	<a href="log.jsp" class = "gets btn btn-danger" style="text-align: center;" >Log Out</a>
 <div class="container">
        <nav class="menu navbar navbar-default">
            <ul class="main-menu">
                <li class="active"><i class="fa fa-home"></i>Inventory</li>
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
		<form action="<%= request.getContextPath() %>/product_input" class="contact100-form " method="post">
				<h1><span class="contact100-form-title">
					Inventory
				</span>
				</h1>
				<div class="wrap-input100 bg1" data-validate="Please Type Your Name">
					<span class="label-input100" >PRODUCT NAME *</span>
					<input class="input100" type="text" Required name="Product_name" placeholder="Enter Name">
				</div>


				<div class="wrap-input100 input100-select bg1">
					<span class="label-input100">Product category *</span>
					<div>
						<select class="js-select2" name="category" Required>
							<option value="">Please chooses</option>
							<option value="Goods">Goods</option>
							<option value="Services">Services</option>
							<option value="Experiences">Experiences</option>
							<option value="Convenience">Convenience</option>
							<option value="Shopping">Shopping</option>
							<option value="Specialty Goods">Specialty Goods</option>
							<option value="Industrial Goods">Industrial Goods</option>
							<option value="Consumer Goods">Consumer Goods</option>
						</select>
						<div class="dropDownSelect2"></div>
					</div>
				</div>
				<div class="wrap-input100 input100-select bg1">
					<span class="label-input100">Product condition *</span>
					<div>
						<select class="js-select2" name="condition" Required>
							<option value="">Please chooses</option>
							<option value="damaged">Damaged</option>
							<option value="not damaged">Not damaged</option>
						</select>
						<div class="dropDownSelect2"></div>
					</div>
				</div>
				<div class="wrap-input100 validate-input bg1" data-validate="Please Type Your Name">
					<span class="label-input100">Product Expiry date *</span>
					<input class="input100" type="date" name="expdate" Required placeholder="dd/mm/yyyy">
				</div>

				<div class="w-full dis-none js-show-service">
					<div class="wrap-contact100-form-radio">
						<span class="label-input100">Is products Perishable?</span>

						<div class="contact100-form-radio m-t-15">
							<input class="input-radio100" id="radio1" Required type="radio" name="perishable" value="yes" checked="checked">
							<label class="label-radio100" for="radio1">
								Yes
							</label>
						</div>

						<div class="contact100-form-radio">
							<input class="input-radio100" id="radio2" Required type="radio" name="perishable" value="no">
							<label class="label-radio100" for="radio2">
								No
							</label>
						</div>
					</div>

				</div>
				<div class="wrap-input100 validate-input bg0 rs1-alert-validate" data-validate = "Please Type Your Message">
					<span class="label-input100">Description *</span>
					<input type="text" class="input100" name="description" Required placeholder="describe here...">
				</div>

				<div class="container-contact100-form-btn">
					<input type="submit" class="contact100-form-btn">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
				</div>
			</form>
			</div>
	</div>
                
            </div>
        </article>
    </div>
</body>
</html>