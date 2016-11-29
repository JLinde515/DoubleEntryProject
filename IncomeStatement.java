

public class IncomeStatement {
	
	private double revenue;
	private double expenses;
	private double netOperatingIncome;
	
	public IncomeStatement(double thisRevenue, double thisExpenses)
	{
		revenue = thisRevenue;
		thisExpenses = thisExpenses;
		netOperatingIncome = revenue - expenses;
	}
	
	public String printIncomeStatement()
	{
		String message = null;
		return message;
	}
	

}
