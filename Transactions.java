
public class Transactions {
	
	private int serialNo = 1001;
	private double amount;
	private boolean credit;
	private boolean debit;
	private String description;
	
	/*
	 * Creates new ledger for T-account entry with a serial number, amount, whether a credit or debit, and a
	 * description
	 */
	
	public Transactions(int thisSerialNo, double thisAmount, boolean thisCredit,
			boolean thisDebit, String thisDescription)
	{
		serialNo = thisSerialNo;
		amount = thisAmount;
		credit = thisCredit;
		debit = thisDebit;
		description = thisDescription;
		
		serialNo++;
	}
	
	/*
	 * returns serialNo for entry
	 */
	
	public int getSerialNo()
	{
		return serialNo;
	}
	
	/*
	 * returns amount for entry
	 */
	
	public double getAmount()
	{
		return amount;
	}
	
	/*
	 * returns bool of credit for entry
	 */
	
	public boolean getCredit()
	{
		return credit;
	}
	
	/*
	 * returns boolean of debit for entry 
	 */
	
	public boolean getDebit()
	{
		return debit;
	}
	
	/*
	 * returns description for entry 
	 */
	
	public String getDescription()
	{
		return description;
	}

}
