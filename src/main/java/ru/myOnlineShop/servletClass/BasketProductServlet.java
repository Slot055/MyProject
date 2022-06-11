package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.buy.Basket;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.clientServise.BuyService;
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
            StatusAccount statusAccount = (StatusAccount) request.getSession().getAttribute("statusAccount");
            int item = Integer.parseInt(request.getParameter("item"));
            Product product = productDataBase.get().selectOne(item,request);
            if (statusAccount == StatusAccount.USER || statusAccount == StatusAccount.ADMIN) {
                if (product != null) {
                    request.setAttribute("product", product);
                    List<Basket> basketProducts = buyService.get().addToBasket(request, item, product);
                    request.getSession().setAttribute("basketProducts", basketProducts);
                    getServletContext().getRequestDispatcher("/basket.jsp").forward(request,response);
                } else {
                    response.getWriter().print("Произошла непредвиденная ошибка");
                    getServletContext().getRequestDispatcher("/notFound.jsp").include(request, response);
                }
            } else {
                response.getWriter().print("Совершать покупки могут только зарегистрированные пользователи, необходимо пройти процесс регистрации или войти в аккаунт");
                getServletContext().getRequestDispatcher("/notFound.jsp").include(request, response);

            }
        } catch (Exception ex) {
            response.getWriter().print("Произошла непредвиденная ошибка");
            getServletContext().getRequestDispatcher("/notFound.jsp").include(request, response);

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
        request.getRequestDispatcher("/basket.jsp").forward(request, response);
    }
}
