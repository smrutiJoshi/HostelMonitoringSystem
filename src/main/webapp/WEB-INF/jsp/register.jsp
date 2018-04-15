<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<!DOCTYPE html>
<html lang="en"><head>
<meta charset="utf-8">
<title>JavaScript Form Validation using a sample registration form</title>
<meta name="keywords" content="example, JavaScript Form Validation, Sample registration form" />
<meta name="description" content="This document is an example of JavaScript Form Validation using a sample registration form. " />
<link rel='stylesheet' href='js-form-validation.css' type='text/css' />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
<script src="sample-registration-form-validation.js"></script>
</head>
<body onLoad="document.registration.userid.focus();">
<h1>Registration Form</h1>
<p>Use tab keys to move from one input field to the next.</p>
<form name='registration' onSubmit="return formValidation();" action="/RegisterController" method="POST"  modelAttribute="register">
<ul>
<label for="rollno">RollNO:</label>
<input type="number" name="rollno"  /></br>

<label for="name">Name:</label>
<input type="text" name="name" /></br>

<label for="address">Address:</label>
<input type="text" name="address" size="50" /></br>
<label for="phno">PhNO:</label>
<input type="text" name="phno" size="12" /></br>

<label for="branch">Branch:</label>
<select name="branch"></br>
<option selected="" value="Default">Please select a Department:</option>
<option value="ETC">ETC</option>
<option value="MECH">MECH</option>
<option value="COMP">COMP</option>
<option value="CIVIL">CIVIL</option>
<option value="IT">IT</option></select>
<label for="sem">Sem:</label>
<select name="sem"></br>
<option selected="" value="Default">Please select semester</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
</select></br>
<label for="date">Date:</label>
<input type="date" name="date"  /></br>
<label for="username">UserName:</label>
<input type="text" name="username" size="50" /></br>
<label for="passid">Password:</label>
<input type="password" name="passid" size="12" /></br>
<input type="submit" name="submit" value="Submit" />
</ul>
</form>
</body>
</html>
