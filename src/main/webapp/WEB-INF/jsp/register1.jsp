<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <title>Register</title>
</head>
<body>
<div class="container">
  <h2>Please Enter Details</h2>
  <form action="/RegisterController" method="POST"  modelAttribute="registers">
    <div class="form-group">
      <label for="rollno">Roll no:</label>
      <input type="text" class="form-control" id="rollno" placeholder="Enter" name="rollno">
    </div>
   <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter" name="name">
    </div>
   
   <div class="form-group">
      <label for="addr">Address:</label>
      <input type="text" class="form-control" id="addr" placeholder="Enter dob as password" name="addr">
    </div>
    <div class="form-group">
      <label for="phno">Phn no:</label>
      <input type="text" class="form-control" id="phno" placeholder="Enter" name="phno">
    </div>
    <div class="form-group">
      <label for="branch">Branch:</label>
      <select name="branch">
      <option selected="" value="Default">Please select a Department:</option>
<option value="ETC">ETC</option>
<option value="MECH">MECH</option>
<option value="COMP">COMP</option>
<option value="CIVIL">CIVIL</option>
<option value="IT">IT</option></select>
      </select>
      </div>
    <div class="form-group">
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
    
    </div>
    <div class="form-group">
      <label for="date">Date:</label>
      <input type="date" class="form-control" id="date" placeholder="Enter" name="dob">
    </div>
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter" name="username">
    </div>
   <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter" name="password" value="admin">
    </div>
   
   
   
    <button type="submit" class="btn btn-default">Submit</button>
  
   </form>
</div>
</body>
</html>