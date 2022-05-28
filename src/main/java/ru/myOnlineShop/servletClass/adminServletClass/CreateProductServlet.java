package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.clientServise.clientAccountService.AccountService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/createProductDB")
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
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            @SuppressWarnings("unchecked")
            AtomicReference<AccountService> accountService = (AtomicReference<AccountService>) request.getServletContext().getAttribute("accountService");
            if (accountService.get().repeatCheckProduct(request, response, typeProduct, categoryProduct, groupProduct, nameProduct, (int) price)) {
                product = null;

            } else {
                product = new Product(typeProduct, categoryProduct, groupProduct, nameProduct, price, description, quantity);
            }
            if (product != null) {
                productDataBase.get().insert(product);
                response.getWriter().print(product);
                response.getWriter().print("<html><head><p>Товар добавлен в Базу Данных</a></p></body ></html > ");

            } else {
                response.getWriter().print("<html><head><p>Товар с такими характеристиками уже существует в Базе Данных</a></p></body ></html > ");
                response.getWriter().print("<html><head><p><a href=\"./sellerJSP/product/createProductDataBase.jsp\">На страницу заведения товара</a></p></body></html>");
            }
            response.getWriter().print("<html><head><p><a href=\"/productDataBaseAll\">К списку товаров</a></p></body></html>");
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");

        } catch (Exception ex) {
            System.out.println(ex);
            getServletContext().getRequestDispatcher("/sellerJSP/product/createProductDataBase.jsp").forward(request, response);
        }


    }

}
