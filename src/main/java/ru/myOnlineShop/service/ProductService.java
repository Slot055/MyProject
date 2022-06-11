package ru.myOnlineShop.service;

import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.product.Product;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Float.*;

public class ProductService {


    public boolean repeatCheckProduct(HttpServletRequest request, String typeProduct, String categoryProduct, String groupProduct, String nameProduct, int price) throws IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) request.getServletContext().getAttribute("productDataBase");
        ArrayList<Product> productBase = productDataBase.get().select(request);
        for (Product p : productBase) {
            if (p.getTypeProduct().equals(typeProduct) && p.getCategoryProduct().equals(categoryProduct) &&
                    p.getGroupProduct().equals(groupProduct) && p.getNameProduct().equals(nameProduct) &&
                    p.getPrice() == price) {
                return true;
            }

        }
        return false;
    }

    public ArrayList<Product> searchProductToParameter(HttpServletRequest request) throws SQLException {
        @SuppressWarnings("unchecked")
        AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) request.getServletContext().getAttribute("productDataBase");
        String typeProduct = request.getParameter("typeProduct");
        String categoryProduct = request.getParameter("categoryProduct");
        String groupProduct = request.getParameter("groupProduct");
        String nameProduct = request.getParameter("nameProduct");
        double minPrice = Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
        ArrayList<Product> productLot = productDataBase.get().selectLot(request, typeProduct, categoryProduct, groupProduct, nameProduct, minPrice, maxPrice);

        return productLot;
    }


}
