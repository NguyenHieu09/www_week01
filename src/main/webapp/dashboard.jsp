<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="org.checkerframework.checker.units.qual.A" %>
<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/05/2023
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
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
<style>
    th {
        background-color: #66FFFF !important;
        text-align: center;
    }
</style>
<body>
<form action="ControllerServlet?action=logOut" method="post">
    <div style="display: flex; justify-content: flex-end;">
        <button type="submit" name="action" class="btn btn-primary">LOG OUT</button>
<%--        <a href="Log.jsp">file log</a>--%>
        <a href="Log.jsp" class="btn btn-info">File log</a>
    </div>
</form>

<%
    Account ac = (Account) session.getAttribute("accountLogin");;
%>
<div align="center">
    <h3>Thông tin admin</h3>
    <div class="row justify-content-center">
        <div class="col-md-2">
            <p>ID: <%=ac.getId()%></p>
            <p>Fullname: <%=ac.getFullName()%></p>
        </div>
        <div class="col-md-2">
            <p>Phone: <%=ac.getPhone()%></p>
            <p>Email: <%=ac.getEmail()%></p>
        </div>
    </div>
</div>

<h2 align="center">List Account</h2>
<table class="table table-hover table-bordered">
    <%
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accountList = accountRepository.getAllAccount();
    %>
    <tr>
        <th>Id</th>
        <th>FullName</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Status</th>
        <th>Password</th>
        <th colspan="3" ><a href="addAccount.jsp" class="text-decoration-none text-secondary">New Account</a></th>

    </tr>
    <%
    for(Account account:accountList){
        String id = account.getId();
        String editString = "updateAccount.jsp?id="+id;
        String deleteString = "ControllerServlet?action=updateStatus&id="+id;
        String grant = "ControllerServlet?action=grantPermission&id="+id;
    %>
    <tr>
        <td><%=id%></td>
        <td><%=account.getFullName()%></td>
        <td><%=account.getPhone()%></td>
        <td><%=account.getEmail()%></td>
        <td><%=account.getStatus()%></td>
        <td><%=account.getPassword()%></td>
        <td><a href=<%=editString%>>update</a></td>
        <td><a href=<%=deleteString%>>delete</a></td>
        <td><a href=<%=grant%>>Grant permissions</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>
