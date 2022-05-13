package ru.myOnlineShop.model.customer.clientServise.clientAccountService;

import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;

import java.sql.*;
import java.util.ArrayList;

public class AccountServiceDB {

    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static ArrayList<ClientAccount> select() {

        ArrayList<ClientAccount> clientAccountBaseBD = new ArrayList<ClientAccount>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM accountdatabase.account");
                while (resultSet.next()) {

                    String login = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    int idAccount = resultSet.getInt(3);
                    StatusAccount statusAccount = StatusAccount.valueOf(resultSet.getString(4));
                    Client client = (Client) resultSet.getObject(5);
                    ClientAccount clientAccountBD = new ClientAccount(login, password, idAccount, statusAccount, client);
                    clientAccountBaseBD.add(clientAccountBD);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clientAccountBaseBD;
    }

    public static ClientAccount selectOne(int id) {

        ClientAccount clientAccountBD = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "SELECT * FROM clientAccount WHERE id=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(3, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {

                        String login = resultSet.getString(1);
                        String password = resultSet.getString(2);
                        int idAccount = resultSet.getInt(3);
                        StatusAccount statusAccountBD = StatusAccount.valueOf(resultSet.getString(4));
                        Client client = (Client) resultSet.getObject(5);
                        clientAccountBD = new ClientAccount(login, password, idAccount, statusAccountBD, client);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clientAccountBD;
    }

    public static int insert(ClientAccount clientAccount) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "INSERT INTO clientAccountBase (login,password,idAccount,statusAccount,client) Values (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, clientAccount.getLogin());
                    preparedStatement.setString(2, clientAccount.getPassword());
                    preparedStatement.setInt(3, clientAccount.getIdAccount());
                    preparedStatement.setObject(4, clientAccount.getStatusAccount());
                    preparedStatement.setObject(5, clientAccount.getClient());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(ClientAccount clientAccountBD) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "UPDATE products SET login = ?, password = ? WHERE idAccount = ?, statusAccount = ?, client = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, clientAccountBD.getLogin());
                    preparedStatement.setString(2, clientAccountBD.getPassword());
                    preparedStatement.setInt(3, clientAccountBD.getIdAccount());
                    preparedStatement.setObject(4, clientAccountBD.getStatusAccount());
                    preparedStatement.setObject(5, clientAccountBD.getClient());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "DELETE FROM clientAccount WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(3, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}

