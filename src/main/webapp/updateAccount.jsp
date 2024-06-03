<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="org.checkerframework.checker.units.qual.A" %>
<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="vn.edu.iuh.fit.models.Status" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/07/2023
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<body class="d-flex justify-content-center align-items-center">
<form action="ControllerServlet?action=updateAccount" method="post" style="width: 60%!important">
    <h2 align="center">Update Account</h2>

    <%
    String accId =request.getParameter("id");
        AccountRepository accountRepository = new AccountRepository();
        Account account = accountRepository.findAccountById(accId);
    %>

    <div class="mb-3">
        <label for="id" class="form-label">Account ID</label>
        <input value="<%= account.getId() %>" type="text" class="form-control disabled" name="accId"
               id="id" required readonly>
    </div>
    <div class="mb-3">
        <label for="full-name" class="form-label">Full name</label>
        <input value="<%= account.getFullName() %>" type="text" class="form-control"
               name="full-name" id="full-name" required>
         
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input value="<%= account.getPassword() %>" type="password" class="form-control"
               name="password" id="password" required>
         
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input value="<%= account.getEmail() == null ? "" : account.getEmail() %>" type="email" class="form-control"
               name="email" id="email">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input value="<%= account.getPhone() == null ? "" : account.getPhone() %>" type="tel" class="form-control"
               name="phone" id="phone">
         
    </div>
    <div class=mb-3">
        <label for="status" class="form-label">Status:</label>
        <select id="status" name="status" class="form-control">
            <option value="0" <%= (account.getStatus().getValue() == 0) ? "selected" : "" %>><%=Status.DEACTIVE%></option>
            <option value="1" <%= (account.getStatus().getValue() == 1) ? "selected" : "" %>><%=Status.ACTIVE%></option>
            <option value="-1" <%= (account.getStatus().getValue() == -1) ? "selected" : "" %>><%=Status.DELETED%></option>
        </select>
    </div>
    <button name="action" type="submit" class="btn btn-success" style="margin-left: 45%;margin-top: 30px">Update</button>
</form>
</body>
</html>
