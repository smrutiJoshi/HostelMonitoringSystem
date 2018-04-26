<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    
        <script type="text/javascript">
            function changeAction()
            {
            	var e = document.getElementById("ltype");
            	var strUserType = e.options[e.selectedIndex].value;
            	
            	if(strUserType=="admin")
            	document.loginForm.action = "/LoginController";
               else
            	   document.loginForm.action = "/LoginStudentController";  
            	//document.loginForm.submit();
            	
            	//alert(strUserType);
            }
            
           
        </script>
    </head>
    <body>
        <h3>Login</h3>
        <form:form name="loginForm" action="/LoginController" method="POST"  modelAttribute="credential">
             <table>
               <tr>
                    <td><form:label path="logintype" >Name</form:label></td>
                   <td><form:select id="ltype" path="logintype" onchange="changeAction();">
                   
                    <option value="admin">Admin</option>
        			<option value="student">Student</option>
        
                   
                   </form:select> 
                   </td>
                   
                   
                  
        
    
                </tr>
               
                <tr>
                    <td><form:label path="username">Name</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input type="password"  path="password"/></td>
                </tr>
                
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>