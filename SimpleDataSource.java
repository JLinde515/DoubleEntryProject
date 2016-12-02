/**
 * Created by johnlinde on 11/8/16.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpleDataSource
{
    private static String url;
    private static String username;
    private static String password;

    public static void init(String fileName)
            throws IOException, ClassNotFoundException
    {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(fileName);
        properties.load(in);

        String driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        if (url == null) url = "jdbc:derby:BigJavaDB;create=true";
        username = properties.getProperty("jdbc.username");
        if (username == null) username = "";
        password = properties.getProperty("jdbc.password");
        if (password == null) password = "";
        if (driver != null)
            Class.forName(driver);
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username, password);
    }
}