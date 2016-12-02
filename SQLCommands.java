/**
 * Created by johnlinde on 11/8/16.
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;


public class SQLCommands
{

    public static void initialize() throws SQLException
    {
        try (Connection conn = SimpleDataSource.getConnection())
        {
            try (Statement stat = conn.createStatement())
            {

                Scanner in = new Scanner(System.in);
                //Create BalanceSheet Table with Assets, Liabilities, StockholdersEquity
                stat.execute("CREATE TABLE BalanceSheet (Assets VARCHAR(15), Liabilities VARCHAR(15), StockholdersEquity VARCHAR(15))");
                System.out.print("Enter assets: ");
                double assets = in.nextDouble();
                System.out.print("Enter liabilities: ");
                double liabilities = in.nextDouble();
                double stockEquity = assets - liabilities;
                    /*
                    Sets accounts class variables to user input
                     */
                Accounts.totalAssets = assets;
                Accounts.totalLiabilities = liabilities;
                Accounts.stockholdersEquity = stockEquity;

            }
        }
    }
}
