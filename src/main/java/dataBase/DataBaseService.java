package dataBase;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseService {

    public DataBaseService() throws IOException {

    }

    public static Connection getConnectionContext(HttpServletRequest request) {

        Connection connection = (Connection) request.getServletContext().getAttribute("connection");

        return connection;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/db.properties"))) {
            properties.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static Connection getConnection() {
        Properties properties = getProperties();
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
