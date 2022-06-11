package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
        ArrayList<Product> productBase = productDataBase.get().select(request);
        request.setAttribute("productBase", productBase);
        Set<Product> productBaseSet = new HashSet<>();
        request.setAttribute("productBaseSet", productBaseSet);
        try {
            getServletContext().getRequestDispatcher("/catalogProduct.jsp").forward(request, response);

        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        @SuppressWarnings("unchecked")
        AtomicReference<ProductService> productServise = (AtomicReference<ProductService>) request.getServletContext().getAttribute("productService");
        try {
            ArrayList<Product> productLot = productServise.get().searchProductToParameter(request);
            request.setAttribute("productLot", productLot);

            response.getWriter().print(productLot);
            request.getRequestDispatcher("/searchProductResult.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}