<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 11/05/2023
  Time: 1:37 AM
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
<body class="d-flex justify-content-center align-items-center" style="background-color: #ADD8E6">
<form action="ControllerServlet?action=insertAccount" method="post" style="width: 50%!important">
    <h2 style="margin-left: 40%">Insert Account</h2>
    <div class="mb-3">
        <label for="id" class="form-label">Id: </label>
        <input id="id" class="form-control" name="id" required/><br/>
    </div>

    <div class="mb-3">
        <label for="name" class="form-label">Name: </label>
        <input id="name" class="form-control" name="name" required/><br/>
    </div>

    <div class="mb-3">
        <label for="pass" class="form-label">Password: </label>
        <input id="pass" class="form-control" name="pass" type="password" required/><br/>
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Email: </label>
        <input id="email" class="form-control" name="email" type="email" required/><br/>
    </div>

    <div class="mb-3">
        <label for="phone" class="form-label">Phone: </label>
        <input id="phone" class="form-control" name="phone" type="tel" required/><br/>
    </div>

    <input type="submit" value="Insert" class="btn btn-success"/>
    <input type="reset" value="Clear" class="btn btn-danger"/>
</form>
</body>
</html>
