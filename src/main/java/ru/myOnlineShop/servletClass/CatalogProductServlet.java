package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;


@WebServlet(urlPatterns = "/catalog")
public class CatalogProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
        ArrayList<Product> productBase = productDataBase.get().select();
        request.setAttribute("productBase", productBase);
        Set<Product> productBaseSet = new HashSet<>();
        request.setAttribute("productBaseSet",productBaseSet);
        try {
           /* String typeProduct = request.getParameter("tyPeProduct");
            String categoryProduct = request.getParameter("categoryProduct");
            String groupProduct = request.getParameter("groupProduct");
            String nameProduct = request.getParameter("nameProduct");
            ArrayList<Product> productLot = productDataBase.get().selectLot(typeProduct,categoryProduct, groupProduct, nameProduct);
            if (productLot != null) {
                request.setAttribute("productLot", productLot);*/
                getServletContext().getRequestDispatcher("/catalogProduct.jsp").forward(request, response);

         /*   } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }*/
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}