package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.dao.AccountDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/deleteAccountDB")
public class DeleteAccountDataBaseServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            @SuppressWarnings("unchecked")
            AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
            int idAccount = Integer.parseInt(request.getParameter("idAccount"));
            accountDataBase.get().delete(idAccount);


            response.sendRedirect(request.getContextPath() + "/accountDataBaseAll");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}
