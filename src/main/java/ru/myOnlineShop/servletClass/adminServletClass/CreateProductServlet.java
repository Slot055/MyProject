package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.productService.ProductService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/regAccount/inputAccount/createProductDB")
public class CreateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        try {
            Product product;
            String typeProduct = request.getParameter("typeProduct");
            String categoryProduct = request.getParameter("categoryProduct");
            String groupProduct = request.getParameter("groupProduct");
            String nameProduct = request.getParameter("nameProduct");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            @SuppressWarnings("unchecked")
            AtomicReference<ProductService> productService = (AtomicReference<ProductService>) request.getServletContext().getAttribute("productService");
            if (productService.get().repeatCheckProduct(request, typeProduct, categoryProduct, groupProduct, nameProduct, (int) price)) {
                product = null;

            } else {
                product = new Product(typeProduct, categoryProduct, groupProduct, nameProduct, price, description);
            }
            if (product != null) {
                productDataBase.get().insert(product);
                response.getWriter().print(product);
                response.getWriter().print("<html><head><p>Товар добавлен в Базу Данных</a></p></body ></html > ");

            } else {
                response.getWriter().print("<html><head><p>Товар с такими характеристиками уже существует в Базе Данных</a></p></body ></html > ");
                response.getWriter().print("<html><head><p><a href=\"./sellerJSP/product/createProductDataBase.jsp\">На страницу заведения товара</a></p></body></html>");
            }
            response.getWriter().print("<html><head><p><a href=\"/regAccount/inputAccount/productDataBaseAll\">К списку товаров</a></p></body></html>");
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");

        } catch (Exception ex) {
            System.out.println(ex);
            getServletContext().getRequestDispatcher("/sellerJSP/product/createProductDataBase.jsp").forward(request, response);
        }


    }

}
