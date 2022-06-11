package ru.myOnlineShop.servletClass;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/regAccount/inputAccount/logout")
public class LogOutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final HttpSession session = request.getSession();
        session.invalidate();

        //response.sendRedirect(super.getServletContext().getContextPath());
        response.sendRedirect("/index.jsp");
    }


}
