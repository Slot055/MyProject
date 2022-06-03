package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/regAccount/inputAccount/productDataBaseAll")
public class ListProductsDataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
        ArrayList<Product> productBase = productDataBase.get().select();
        request.setAttribute("productBase", productBase);

        getServletContext().getRequestDispatcher("/sellerJSP/product/productDataBaseAll.jsp").forward(request, response);
    }
}
