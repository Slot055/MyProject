package ru.myOnlineShop.servletClass;

import org.joda.time.DateTime;
import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.OnlineShop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/onlineShop")
public class OnlineShopServlet extends HttpServlet {

    String command;
    DateTime date = new DateTime();
    OnlineShop onlineShop = BuilderObject.buildOnlineShop();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        request.getSession().getAttribute("clientAccountBase");
        command = request.getParameter("command");
        if ("info".equals(command)) {
            response.getWriter().append(onlineShop.infoStore() + "<br>").append(onlineShop.getTimeStore(date));
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");

        } else if ("authentification".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentificationAccount.jsp");
            requestDispatcher.forward(request, response);
        } else if ("catalog".equals(command)) {
           request.getRequestDispatcher("/catalog").forward(request,response);
        } else if ("searchProduct".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/searchProduct.jsp");
            requestDispatcher.forward(request, response);
        } else if ("viewBasket".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/basket.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}
