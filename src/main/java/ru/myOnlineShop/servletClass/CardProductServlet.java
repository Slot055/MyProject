package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/cardProduct")
public class CardProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            int item = Integer.parseInt(request.getParameter("item"));
            Product product = productDataBase.get().selectOne(item,request);
            if (product != null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/cardProduct.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
