package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.customer.Basket;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.clientServise.clientBuyService.BuyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/regAccount/inputAccount/basketProduct")
public class BasketProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            @SuppressWarnings("unchecked")
            AtomicReference<BuyService> buyService = (AtomicReference<BuyService>) getServletContext().getAttribute("buyService");
            @SuppressWarnings("unchecked")
            AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) getServletContext().getAttribute("productDataBase");
            int item = Integer.parseInt(request.getParameter("item"));
            Product product = productDataBase.get().selectOne(item);
            if (product != null) {
                request.setAttribute("product", product);
                List<Basket> basketProducts = buyService.get().addToBasket(request, item, product);
                request.getSession().setAttribute("basketProducts", basketProducts);
                response.getWriter().print("Товар добавлен в корзину");
                response.getWriter().print("<html><head><p><input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/></p></body></html>");
            } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        @SuppressWarnings("unchecked")
        AtomicReference<BuyService> buyService = (AtomicReference<BuyService>) getServletContext().getAttribute("buyService");
        int item = Integer.parseInt(request.getParameter("item"));
        List<Basket> basketProducts = buyService.get().removeFromBasket(request, item);
        request.getSession().setAttribute("basketProducts", basketProducts);
        request.getRequestDispatcher("/basket.jsp").forward(request,response);
    }
}
