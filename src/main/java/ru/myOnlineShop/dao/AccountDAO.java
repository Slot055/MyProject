package ru.myOnlineShop.dao;

import dataBase.DataBaseService;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.CashAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;

public class AccountDAO extends HttpServlet implements DAO {

    public ArrayList<ClientAccount> select(HttpServletRequest request) {
        final ArrayList<ClientAccount> clientAccountBase = new ArrayList<>();
        Connection connection = (Connection) request.getServletContext().getAttribute("connection");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accountdatabase.account");
            while (resultSet.next()) {

                int idAccount = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                StatusAccount statusAccount = StatusAccount.valueOf(resultSet.getString(4));
                Client client = (new Client(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
                ClientAccount clientAccount = new ClientAccount(idAccount, login, password, statusAccount, client);
                clientAccountBase.add(clientAccount);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clientAccountBase;
    }

    public ClientAccount selectOne(int idAccount,HttpServletRequest request) throws SQLException {

        ClientAccount clientAccount = null;
        Connection connection = (Connection) request.getServletContext().getAttribute("connection");
        try {
            String sql = "SELECT * FROM accountdatabase.account WHERE idAccount=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idAccount);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    int idAccount1 = resultSet.getInt(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    StatusAccount statusAccount = StatusAccount.valueOf(resultSet.getString(4));
                    Client client = (new Client(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                            resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
                    clientAccount = new ClientAccount(idAccount1, login, password, statusAccount, client);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clientAccount;
    }

    public int insert(ClientAccount clientAccount,HttpServletRequest request) throws SQLException {

        Connection connection = (Connection) request.getServletContext().getAttribute("connection");
        try {
            String sql = "INSERT INTO accountdatabase.account (login,password,statusAccount,name,lastName,gender,age,phoneNumber,email) Values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, clientAccount.getLogin());
                preparedStatement.setString(2, clientAccount.getPassword());
                preparedStatement.setString(3, clientAccount.getStatusAccount().getName());
                preparedStatement.setString(4, clientAccount.getClient().getName());
                preparedStatement.setString(5, clientAccount.getClient().getLastName());
                preparedStatement.setString(6, clientAccount.getClient().getGender());
                preparedStatement.setString(7, clientAccount.getClient().getAge());
                preparedStatement.setString(8, clientAccount.getClient().getPhoneNumber());
                preparedStatement.setString(9, clientAccount.getClient().getEmail());

                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public int update(ClientAccount clientAccount,HttpServletRequest request) throws SQLException {

        Connection connection = (Connection) request.getServletContext().getAttribute("connection");
        try {
            String sql = "UPDATE accountdatabase.account SET login = ?, password = ?, statusAccount = ?, name = ?, lastName = ?, gender = ?, age = ?,phoneNumber = ?,email = ? WHERE idAccount = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, clientAccount.getLogin());
                preparedStatement.setString(2, clientAccount.getPassword());
                preparedStatement.setString(3, clientAccount.getStatusAccount().getName());
                preparedStatement.setString(4, clientAccount.getClient().getName());
                preparedStatement.setString(5, clientAccount.getClient().getLastName());
                preparedStatement.setString(6, clientAccount.getClient().getGender());
                preparedStatement.setString(7, clientAccount.getClient().getAge());
                preparedStatement.setString(8, clientAccount.getClient().getPhoneNumber());
                preparedStatement.setString(9, clientAccount.getClient().getEmail());
                preparedStatement.setInt(10, clientAccount.getIdAccount());
                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public int delete(int idAccount,HttpServletRequest request) throws SQLException {

        Connection connection = (Connection) request.getServletContext().getAttribute("connection");
        try {
            String sql = "DELETE FROM accountdatabase.account WHERE idAccount = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idAccount);

                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

}

