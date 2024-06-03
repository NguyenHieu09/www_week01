package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Logs;
import vn.edu.iuh.fit.models.Status;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.repositories.LogRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        AccountRepository acc = new AccountRepository();
        LogRepository logRepository = new LogRepository();

        PrintWriter out = null;
        if (action.equals("login")) {
            out = resp.getWriter();
            String email = req.getParameter("email");
            String pass = req.getParameter("pwd");


            AccountRepository accountRepository = new AccountRepository();
            try {
                Account login = accountRepository.login(new Account(pass, email));
                if (login == null)
                    out.println("login failed");
                else {
                    //get date time login
                    LocalDateTime loginTime = LocalDateTime.now();
                    req.getSession().setAttribute("loginTime", loginTime);

                    long id =  logRepository.getLogs().size()+1;
                    Logs logs = new Logs(id, login,LocalDateTime.now(), LocalDateTime.now(),"");
                    req.getSession().setAttribute("log", logs);

                    req.getSession().setAttribute("accountLogin", login);
                    GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
                    GrantAccess grantAccess = grantAccessRepository.getGrantAccessByAccountId(login.getId());
                    req.getSession().setAttribute("grantAccess", grantAccess);
                    if (grantAccess.getId().equals("admin"))
                        resp.sendRedirect("dashboard.jsp");
                    else
                        resp.sendRedirect("Account.jsp");
                    logRepository.addLog(logs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equals("updateStatus")) {
            String id = req.getParameter("id");
            try {
                acc.updateStatusAccount(id, Status.DELETED);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("dashboard.jsp");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        AccountRepository accountRepository = new AccountRepository();
        LogRepository logRepository = new LogRepository();

        if(action.equals("insertAccount")){
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String pass = req.getParameter("pass");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Account account = new Account(id, name, pass, email,phone);
            try {
                accountRepository.addAccount(account);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("dashboard.jsp");

        }
        else if (action.equals("updateAccount")) {
            String id = req.getParameter("accId");
            String fullName = req.getParameter("full-name");
            String pass = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            int st = Integer.parseInt(req.getParameter("status"));
            Status status ;
            if(st ==1)
                status = Status.ACTIVE;
            else if (st == 0) {
                status = Status.DEACTIVE;
            }
            else status = Status.DELETED;
            Account account = new Account(id, fullName,pass,email,phone,status);
            try {
                accountRepository.updateAccount(account);
                resp.sendRedirect("dashboard.jsp");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        else if (action.equals("logOut")) {

            Logs o = (Logs) req.getSession().getAttribute("log");
            try {
                logRepository.updateLogoutTime(o.getId(),LocalDateTime.now());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect("index.jsp");
        }
    }
}
