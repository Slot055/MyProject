package ru.myOnlineShop.dao;

import dataBase.DataBaseService;
import ru.myOnlineShop.model.product.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements DAO {

    public ArrayList<Product> select() {
        final ArrayList<Product> productBase = new ArrayList<>();

        try (Connection connection = DataBaseService.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accountdatabase.products");
            while (resultSet.next()) {

                int item = Integer.parseInt(resultSet.getString(1));
                String typeProduct = resultSet.getString(2);
                String categoryProduct = resultSet.getString(3);
                String groupProduct = resultSet.getString(4);
                String nameProduct = resultSet.getString(5);
                double price = Double.parseDouble(resultSet.getString(6));
                String description = resultSet.getString(7);

                Product product = new Product(item, typeProduct, categoryProduct, groupProduct, nameProduct, price, description);
                productBase.add(product);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return productBase;
    }

    public Product selectOne(int item) throws SQLException {

        Product product = null;
        try (Connection connection = DataBaseService.getConnection()) {
            String sql = "SELECT * FROM accountdatabase.products WHERE item=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, item);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    int item1 = resultSet.getInt(1);
                    String typeProduct = resultSet.getString(2);
                    String categoryProduct = resultSet.getString(3);
                    String groupProduct = resultSet.getString(4);
                    String nameProduct = resultSet.getString(5);
                    double price = resultSet.getDouble(6);
                    String description = resultSet.getString(7);
                    product = new Product(item1, typeProduct, categoryProduct, groupProduct, nameProduct, price, description);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return product;
    }

    public ArrayList<Product> selectLot(String typeProduct, String categoryProduct, String groupProduct, String nameProduct, double minPrice, double maxPrice) throws SQLException {
        ArrayList<Product> productLot = new ArrayList<>();
        try (Connection connection = DataBaseService.getConnection()) {
            String sql = "SELECT * FROM accountdatabase.products WHERE (typeProduct=? OR categoryProduct=? OR groupProduct=? OR nameProduct=?) OR (price >= ? AND price <= ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, typeProduct);
                preparedStatement.setString(2, categoryProduct);
                preparedStatement.setString(3, groupProduct);
                preparedStatement.setString(4, nameProduct);
                preparedStatement.setDouble(5, minPrice);
                preparedStatement.setDouble(6, maxPrice);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    int item = resultSet.getInt(1);
                    String typeProduct1 = resultSet.getString(2);
                    String categoryProduct1 = resultSet.getString(3);
                    String groupProduct1 = resultSet.getString(4);
                    String nameProduct1 = resultSet.getString(5);
                    double price1 = resultSet.getDouble(6);
                    String description = resultSet.getString(7);
                    Product product = new Product(item, typeProduct1, categoryProduct1, groupProduct1, nameProduct1, price1, description);
                    productLot.add(product);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return productLot;
    }

    public int insert(Product product) throws SQLException {

        try (Connection connection = DataBaseService.getConnection()) {
            String sql = "INSERT INTO accountdatabase.products (typeProduct,categoryProduct,groupProduct,nameProduct,price,description) Values (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, product.getTypeProduct());
                preparedStatement.setString(2, product.getCategoryProduct());
                preparedStatement.setString(3, product.getGroupProduct());
                preparedStatement.setString(4, product.getNameProduct());
                preparedStatement.setDouble(5, product.getPrice());
                preparedStatement.setString(6, product.getDescription());

                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public int update(Product product) throws SQLException {

        try (Connection connection = DataBaseService.getConnection()) {
            String sql = "UPDATE accountdatabase.products SET typeProduct = ?,categoryProduct = ?,groupProduct = ?,nameProduct = ?,price = ?,description = ?,quantity = ? WHERE item = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, product.getTypeProduct());
                preparedStatement.setString(2, product.getCategoryProduct());
                preparedStatement.setString(3, product.getGroupProduct());
                preparedStatement.setString(4, product.getNameProduct());
                preparedStatement.setDouble(5, product.getPrice());
                preparedStatement.setString(6, product.getDescription());
                preparedStatement.setInt(7, product.getItem());
                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public int delete(int item) throws SQLException {

        try (Connection connection = DataBaseService.getConnection()) {
            String sql = "DELETE FROM accountdatabase.products WHERE item = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, item);

                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

}

