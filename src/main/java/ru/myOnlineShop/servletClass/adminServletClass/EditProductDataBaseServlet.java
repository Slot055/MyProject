package ru.myOnlineShop.servletClass.adminServletClass;

import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.product.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/editProductDB")
public class EditProductDataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            int item = Integer.parseInt(request.getParameter("item"));
            Product product = productDataBase.get().selectOne(item);
            if (product != null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/sellerJSP/product/editProductAll.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        try {
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            Product product = BuilderObject.buildProduct(request, response);
            if (product == null) {
                response.getWriter().print("<html><head><p>Товар с такими характеристиками уже существует в Базе Данных</a></p></body ></html > ");
                response.getWriter().print("<html><head><p><a href=\"./sellerJSP/product/createProductDataBase.jsp\">На страницу заведения товара</a></p></body></html>");
                response.getWriter().print("<html><head><p><a href=\"/productDataBaseAll\">К списку товаров</a></p></body></html>");
                response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");
            } else {
                productDataBase.get().update(product);
                response.sendRedirect(request.getContextPath() + "/productDataBaseAll");
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }

    }
}

