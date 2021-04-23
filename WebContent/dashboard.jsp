<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.studentmanagement.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Student st = (Student)request.getAttribute("student"); %>
<h1>Hi <%= st.getName()%> , you are logged in</h1>

<h1>Displaying Student List</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Student Name</b></th>
          <th><b>Student Email</b></th>
          <th><b> UserName</b></th>
           <th><b>Password</b></th>
         </tr>
    
            <tr>
                <td><%=st.getName()%></td>
                <td><%=st.getEmail()%></td>
                <td><%=st.getUserName()%></td>
                <td><%=st.getPassword()%></td>
            </tr>
        </table> 
        <hr/>
</body>
</html>