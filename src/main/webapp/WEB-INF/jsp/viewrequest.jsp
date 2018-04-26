<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.List" %>
  <%@ page import="com.in28minutes.springboot.web.rest.model.Semconfirm" %>
  
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requests</title>
</head>
<body>

        <table >
        <thead>
            <tr>
                <th> Id </th>
                </tr>
        </thead>


<%
List<Semconfirm> sc= (List)request.getAttribute("SemConfirm");
System.out.println("**********************************"+sc.get(0).getSemconfirmid());


%>
<tbody>
<%-- <c:out value="${SemConfirm}"/>  --%>
<%-- <% for(int i=0;i<5;i++){ %>
                
             <c:forEach items="${allNotesOfUser}" var="pp">
                 <tr>
                    <td>
                    
                    <div class="form-group">
      <label for="addr">Address:</label>
      <input type="text" class="form-control" id="addr" placeholder="Enter dob as password" name="addr"  value="<%=sc.get(i).getRollno()%>">
    </div>
                    
                    </td>

                   
                </tr>
   <% } %> --%>
        </tbody>

        <c:forEach items="${SemConfirm}" var="sc">
                <tr>
                    <td><c:out value="${sc.getRollno()}" /></td>
                    <%-- <td><c:out value="${pp.title}" /></td>
                    <td><c:out value="${pp.text}" /></td>
                    <td><c:out value="${pp.color}" /></td>
                    <td><c:out value="${pp.datetime}" /></td>
   --%>              </tr>
        </c:forEach> 
        

    </table>
</body>
</html>