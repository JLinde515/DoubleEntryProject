/**
 * Created by johnlinde on 11/7/16.
 */
public class Accounts {

    /*
        Object identifying variables.
     */

    private static int serialNumbers = 10000;


    private int serialNo;
    private String description;
    private double amount;

    /*
        Class level variables keeping track of each of the Company's accounts.
     */

    public static double stockholdersEquity;
    public static double totalAssets;
    public static double totalLiabilities;
    public static double estimateSE;

    public static double totalRevenue;
    public static double totalExpenses;
    public static double totalIncome;

    private static double accountsPayable;
    private static double accountsReceivable;
    private static double cash;
    private static double stock;
    private static double notesPayable;
    private static double rentExpense;
    private static double wagesExpense;
    private static double revenue;
    private static double supplies;
    private static double operatingExpense;
    private static double unearnedRevenue;
    private static double equipment;
    private static double inventory;

    /*
        Constructs a new object of Accounts class with serialNo, description and amount.
     */

    public Accounts(String thisDescription, double thisAmount)
    {
        description = thisDescription;
        amount = thisAmount;
        serialNo = serialNumbers;
        serialNumbers++;
    }

    /*
    Returns account information including serial number, description, amount.
     */

    public String getAccounts()
    {
        return String.format("%d %s %.2f",
                serialNo, description, amount);
    }

    /*
        Method for setting total assets to a specific value
     */

    public void setTotalAssets(double thisAmount)
    {
        totalAssets = thisAmount;
    }

    /*
        Method for setting total liabilities.
     */

    public static void setTotalLiabilities(double thisAmount)
    {
        totalLiabilities = thisAmount;
    }

    /*
        Methods for crediting and debiting as well as whether that means an entry to the left or
         right side of the T-Account (add or subtract thisAmount). Also methods for
         getting values.
     */

    /*
        @param amount decreasing inventory.
        @return amount in inventory account.
     */

    public double creditInventory(double thisAmount)
    {
        inventory -= thisAmount;
        return inventory;
    }

    /*
        @param amount increasing inventory
        @return amount in inventory.
     */

    public double debitInventory(double thisAmount)
    {
        inventory += thisAmount;
        return inventory;
    }

    /*
        @param amount decreasing equipment account.
        @return amount in equipment account.
     */

    public double creditEquipment(double thisAmount)
    {
        equipment -= thisAmount;
        return equipment;
    }

    /*
        @param amount increasing equipment account.
        @return amount in equipment.
     */

    public double debitEquipment(double thisAmount)
    {
        equipment += thisAmount;
        return equipment;
    }

    /*
        @param amount increasing unearned revenue
        @return amount in unearned revenue account.
     */

    public double creditUnearnedRevenue(double thisAmount)
    {
        unearnedRevenue += thisAmount;
        return unearnedRevenue;
    }

    /*
        @param amount decreasing unearned revenue.
        @return amount in unearned revenue account.
     */

    public double debitUnearnedRevenue(double thisAmount)
    {
        unearnedRevenue -= thisAmount;
        return unearnedRevenue;
    }

    /*
        @param amount decreasing operating expense account.
        @return amount in operating expense account.
     */

    public double creditOperatingExpense(double thisAmount)
    {
        operatingExpense -= thisAmount;
        return operatingExpense;
    }

    /*
        @param amount increasing operating expense account
        @return amount in operating expense account.
     */

    public double debitOperatingExpense(double thisAmount)
    {
        operatingExpense += thisAmount;
        return operatingExpense;
    }

    /*
        @param amount decreasing supplies account.
        @return amoutn in supplies account.
     */

    public double creditSupplies(double thisAmount)
    {
        supplies -= thisAmount;
        return supplies;
    }

    /*
        @param amount increasing supplies account.
        @return amount in supplies account.
     */

    public double debitSupplies(double thisAmount)
    {
        supplies += thisAmount;
        return supplies;
    }

    /*
        @param amount increasing revenue account.
        @return amount in revenue account.
     */

    public double creditRevenue(double thisAmount)
    {
        revenue += thisAmount;
        return revenue;
    }
    /*
        @param amount decreasing revenue account.
        @return amount in revenue account.
     */

    public double debitRevenue(double thisAmount)
    {
        revenue -= thisAmount;
        return revenue;
    }

    /*
        @param amount decreasing wages expense account.
        @return amount in wages expense account.
     */

    public double creditWagesExpense(double thisAmount)
    {
        wagesExpense -= thisAmount;
        return wagesExpense;
    }

    /*
        @param amount increasing wages expense account.
        @return amount in wages expense account.
     */

    public double debitWagesExpense(double thisAmount)
    {
        wagesExpense += thisAmount;
        return wagesExpense;
    }

    /*
        @param amount decreasing rent expense account.
        @return amount in rent expense account.
     */

    public double creditRentExpense(double thisAmount)
    {
        rentExpense -= thisAmount;
        return rentExpense;
    }

    /*
        @param amount increasing in rent expense account.
        @reutnr amount in rent expense account.
     */

    public double debitRentExpense(double thisAmount)
    {
        rentExpense += thisAmount;
        return rentExpense;
    }

    /*
        @param amount increasing notes payable account.
        @return amount in notes payable account.
     */

    public double creditNotesPayable(double thisAmount)
    {
        notesPayable += thisAmount;
        return notesPayable;
    }

    /*
        @param amount decreasing notes payable account.
        @return amount in notes payable account.
     */

    public double debitNotePayable(double thisAmount)
    {
        notesPayable -= thisAmount;
        return notesPayable;
    }

    /*
        @param amount increasing stock account.
        @return amount in stock account.
     */

    public double creditStock(double thisAmount)
    {
        stock += thisAmount;
        return stock;
    }

    /*
        @param amount decreasing stock account.
        @return amount in stock account.
     */

    public double debitStock(double thisAmount)
    {
        stock -= thisAmount;
        return stock;
    }

    /*
        @param amount decreasing in cash account.
        @return amount in cash account.
     */

    public double creditCash(double thisAmount)
    {
        cash -= thisAmount;
        return cash;
    }

    /*
        @param amount increasing cash account.
        @return amount in cash account.
     */

    public double debitCash(double thisAmount)
    {
        cash += thisAmount;
        return cash;
    }

    /*
        @param amount increasing accounts receivable account.
        @return amount in accounts receivable account.
     */

    public double debitAccountsReceivable(double thisAmount)
    {
        accountsReceivable += thisAmount;
        return accountsReceivable;
    }

    /*
        @param amount decreasing in accounts receivable account.
        @return amount in accounts receivable account.
     */

    public double creditAccountsReceivable(double thisAmount)
    {
        accountsReceivable -= thisAmount;
        return accountsReceivable;
    }

    /*
        @param amount increasing accounts payable account.
        @return amount in accounts payable.
     */

    public double creditAccountsPayable(double thisAmount)
    {
        accountsPayable += thisAmount;
        return accountsPayable;
    }

    /*
        @param amount decreasing in accounts payable account.
        @return amount in accounts payable account.
     */

    public double debitAccountsPayable(double thisAmount)
    {
        accountsPayable -= thisAmount;
        return accountsPayable;
    }

    /*
        @return description.
     */

    public String getDescription()
    {
        return description;
    }

    /*
        @return serial no.
     */

    public int getSerialNo()
    {
        return serialNo;
    }

    /*
        Remaining code is to update our variables that will be called in another class to
        update the DB and methods to print the IncomeStatement and BalanceSheet as well as verify
        accounting identities not violated..
     */

    /*
        updates income statement accounts in terms of revenue, expenses, and income.
     */

    public void updateIncomeStatement()
    {
        totalRevenue = revenue;
        totalExpenses = wagesExpense + rentExpense + operatingExpense;
        totalIncome = totalRevenue - totalExpenses;
    }

    /*
        updates balance sheet accounts in terms of assets, liabilities, stock equity.
     */

    public void updateBalanceSheet()
    {
        totalAssets = totalAssets + accountsReceivable + cash + supplies + equipment;
        totalLiabilities = totalLiabilities + accountsPayable + notesPayable + unearnedRevenue;
        stockholdersEquity = stockholdersEquity + stock;
        estimateSE = totalAssets - totalLiabilities;
    }

    /*
        @return estimate SE
     */

    public double getEstimateSE()
    {
        return estimateSE;
    }

    /*
        @return stockholders equity as seen from stock account.
     */

    public double getTotalStockEquity()
    {
        return stockholdersEquity;
    }

    /*
        @return total liabilities.
     */

    public double getTotalLiabilities()
    {
        return totalLiabilities;
    }

    /*
        return total assets.
     */

    public double getTotalAssets()
    {
        return totalAssets;
    }

}
