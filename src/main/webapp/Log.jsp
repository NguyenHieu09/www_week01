<%@ page import="vn.edu.iuh.fit.repositories.LogRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Logs" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/09/2023
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file log</title>
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

<h2 align="center">File Log</h2>
<table class="table table-hover table-bordered">
    <%
        LogRepository logRepository = new LogRepository();
        List<Logs> logsList = logRepository.getLogs();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    %>
    <tr>
        <th>Id</th>
        <th>Account</th>
        <th>Login time</th>
        <th>Logout time</th>
        <th>Notes</th>
    </tr>
    <%
        for (Logs logs:logsList){
    %>
    <tr>
        <td><%=logs.getId()%></td>
        <td><%=logs.getAccount().getId()%></td>
        <td><%=logs.getLoginTime()%></td>
        <td><%=logs.getLogoutTime()%></td>
        <td><%=logs.getNotes()%></td>

    </tr>
    <%}%>
</table>

</body>
</html>
