package ru.myOnlineShop.servletClass;

import org.joda.time.DateTime;
import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.OnlineShop;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/onlineShop")
public class OnlineShopServlet extends HttpServlet {

    String command;
    DateTime date = new DateTime();
    OnlineShop onlineShop = BuilderObject.buildOnlineShop();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().getAttribute("clientAccountBase");
        command = request.getParameter("command");
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        if ("info".equals(command)) {
            response.getWriter().append(onlineShop.infoStore() + "<br>").append(onlineShop.getTimeStore(date));
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");

        } else if ("authentification".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentificationAccount.jsp");
            requestDispatcher.forward(request, response);
        } else if ("katalog".equals(command)) {
            BufferedReader br = new BufferedReader(new FileReader("src/main/dataBase/dataBaseCatalog/PriceList.txt"));
            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                response.getWriter().write(currentLine);
            }
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");
        } else if ("searchProduct".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/searchProduct.jsp");
            requestDispatcher.forward(request, response);
        } else if ("basket".equals(command)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/123.jsp");
            requestDispatcher.forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}
