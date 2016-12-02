import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by johnlinde on 11/24/16.
 */


public class AccountDB {

    private String serialNo;

    public AccountDB(String aSerialNo)
    {
        serialNo = aSerialNo;
    }

    public void addEntry(String desc, float amount, String accountType) throws SQLException
    {
        try (Connection conn = SimpleDataSource.getConnection())
        {
            try (PreparedStatement stat = conn.prepareStatement("INSERT INTO AccountDB (Serial_No, Description, Amount, Type) VALUES (?, ?, ?, ?")) {
                stat.setString(1, serialNo);
                stat.setString(2, desc);
                stat.setFloat(3, amount);
                stat.setString(4, accountType);
                stat.execute();
            }
        }
    }

    public double getAccountBalance() throws SQLException
    {
        try (Connection conn = SimpleDataSource.getConnection())
        {
            try (PreparedStatement stat = conn.prepareStatement("SELECT Amount FROM AccountDB WHERE Type = ?"))
            {
                stat.setString(1, serialNo);

                ResultSet result = stat.executeQuery();

                result.next();

                return result.getFloat(1);
            }
        }
    }
}
