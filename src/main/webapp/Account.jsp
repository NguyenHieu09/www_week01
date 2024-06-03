<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="org.checkerframework.checker.units.qual.A" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="vn.edu.iuh.fit.models.GrantAccess" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/13/2023
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<form action="ControllerServlet?action=logOut" method="post">
    <div style="display: flex; justify-content: flex-end;">
        <button type="submit" name="action" class="btn btn-primary">LOG OUT</button>
        <%--        <a href="Log.jsp">file log</a>--%>
        <a href="Log.jsp" class="btn btn-info">File log</a>
    </div>
</form>
<%
    Account account = (Account) session.getAttribute("accountLogin");
%>
<h2 align="center">Thông tin account</h2>
<div style="margin-left: 45%">
    <p>ID: <%=account.getId()%></p>
    <p>Fullname: <%=account.getFullName()%></p>
    <p>Phone: <%=account.getPhone()%></p>
    <p>Email: <%=account.getEmail()%></p>
    <p>Status: <%=account.getStatus()%></p>

</div>

<%
    GrantAccess grantAccess = (GrantAccess) session.getAttribute("grantAccess");
%>
<div style="margin-left: 45%" >
    <p style="color: red">Role: <%=grantAccess.getId()%></p>
    <p>Note: <%=grantAccess.getNote()%></p>
</div>

<%--<%}%>--%>
</body>
</html>
