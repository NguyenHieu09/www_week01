<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="vn.edu.iuh.fit.models.Status" %>
<%@ page import="vn.edu.iuh.fit.repositories.GrantAccessRepository" %>
<%@ page import="vn.edu.iuh.fit.models.GrantAccess" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.repositories.LogRepository" %>
<%@ page import="vn.edu.iuh.fit.models.Logs" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
          crossorigin="anonymous">
  </script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>login</title>
</head>
<style>
  body {
    background-color: #ADD8E6;
  }
</style>
<body>
<div class="d-flex flex-column align-items-center" style="margin-top: 10%">
  <h2 class="text-center">Log in</h2>

  <form action="ControllerServlet" method="get">
    <div class="mb-3 mt-3">
      <label for="email" class="form-label">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
      <label for="pwd" class="form-label">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary" name="action" value="login">Submit</button>
  </form>
</div>
<%
//  GrantAccessRepository g = new GrantAccessRepository();
//  GrantAccess grantAccess = g.getGrantAccessByAccountId("teo");
//  System.out.println(grantAccess);
//
//  AccountRepository accountRepository = new AccountRepository();
//  Account account = new Account("hieu", "hi", "hieu", "hie", "hon",Status.ACTIVE);
//  boolean a= accountRepository.updateAccount(account);
//System.out.println(a);
//  LogRepository logRepository = new LogRepository();
//  AccountRepository accountRepository = new AccountRepository();
//  Account account = null;
//  try {
//    account = accountRepository.findAccountById("teo");
//  } catch (SQLException e) {
//    throw new RuntimeException(e);
//  } catch (ClassNotFoundException e) {
//    throw new RuntimeException(e);
//  }
//  long id = logRepository.getLogs().size()+1;
//  Logs logs = new Logs(id,account, LocalDateTime.now(),LocalDateTime.now() , "log in");
//  boolean a = false;
//  try {
//    a = logRepository.addLog(logs);
//  } catch (SQLException e) {
//    throw new RuntimeException(e);
//  } catch (ClassNotFoundException e) {
//    throw new RuntimeException(e);
//  }
////  System.out.println(a);
//    LogRepository logRepository = new LogRepository();
//    Logs logs = logRepository.findLogById(1);
//    logs.setLogoutTime(LocalDateTime.now());
//    logRepository.updateLogoutTime(logs);
//
//
//
//  System.out.println(logs);

%>
</body>
</html>