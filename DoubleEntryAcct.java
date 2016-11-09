import java.util.Scanner;

/**
 * Created by johnlinde on 11/7/16.
 */
public class DoubleEntryAcct
{

    public static void main(String[] args)
    {

        /*
                To do update all prompts and code blocks to have credit and debit to Accounts related to I/S. This is inconsistent so far.
                B/S accounts are mostly done. Also each code block needs to have the AccountEntries class updates with the new Account object in order
                to be printed during the print function.

                Plans are to be able to test out the program and make sure it matches hand calculations for any entries by
                November 13th.
         */

        Scanner in = new Scanner(System.in);

        boolean done = false;
        while(!done)
        {
            System.out.println("I) Initialize database A) Add Entry P) Print Q) Quit: ");
            String userInput = in.nextLine().toUpperCase();
            if (userInput.equals("I"))
            {
               System.out.println("Enter Y) Yes to confirm Initialization Q) Quit (Any other button to return to exit) : ");
               String answer = in.nextLine();
                if (answer.equalsIgnoreCase("Y"))
                {
                    System.out.println("Enter assets: ");
                    double assets = in.nextDouble();
                    System.out.println("Enter liabilities: ");
                    double liabilities = in.nextDouble();
                    double stockEquity = assets - liabilities;
                    /*
                    Sets accounts class variables to user input
                     */
                    Accounts.totalAssets = assets;
                    Accounts.totalLiabilities = liabilities;
                    Accounts.stockholdersEquity = stockEquity;
                }
                else if(answer.equalsIgnoreCase("Q"))
                {
                    done = true;
                }
            }
            else if(userInput.equals("A"))
            {
                System.out.print("R) Record sale P) Pay out I) Inventory and equipment S) Stock E) Expenses (Any other button to exit) : ");
                String answer = in.nextLine();
                if (answer.equalsIgnoreCase("R"))
                {
                    System.out.println("Enter if sold T) Today or F) Future? (Any other button to exit): ");
                    String userAnswer = in.nextLine();
                    if (userAnswer.equalsIgnoreCase("T")) {
                        System.out.println("Enter total sale amount: ");
                        double totalSale = in.nextDouble();
                        System.out.println("Enter cash collected: ");
                        double cashCollect = in.nextDouble();
                        System.out.println("Enter A/R: ");
                        double accountsReceivable = in.nextDouble();

                        /*
                        Create account object for total sale, portion paid with cash, and A/R
                        */
                        if (totalSale == cashCollect) {
                            System.out.println("Enter a brief description for the total sale: ");
                            String accountDesc = in.nextLine();
                            in.nextLine();
                            Accounts thisSale = new Accounts(accountDesc, totalSale);
                            thisSale.creditRevenue(totalSale);
                            thisSale.debitCash(totalSale);
                        } else if (totalSale != cashCollect || cashCollect > 0) {

                            System.out.println("Enter a brief description for the portion paid with cash: ");
                            String cashDesc = in.nextLine();
                            Accounts thisCash = new Accounts(cashDesc, cashCollect);
                            thisCash.debitCash(cashCollect);
                            thisCash.creditRevenue(cashCollect);
                            System.out.println("Enter a brief description for the portion paid with A/R: ");
                            String receivablesDesc = in.nextLine();
                            double receivables = totalSale - cashCollect;
                            Accounts thisReceive = new Accounts(receivablesDesc, receivables);
                            thisReceive.debitAccountsReceivable(receivables);
                            thisReceive.creditRevenue(receivables);
                        } else {

                            System.out.println("Enter a brief description for the sale paid with A/R: ");
                            String receivablesDesc = in.nextLine();
                            Accounts thisAccountsReceivable = new Accounts(receivablesDesc, accountsReceivable);
                            thisAccountsReceivable.debitAccountsReceivable(accountsReceivable);
                            thisAccountsReceivable.creditRevenue(accountsReceivable);
                        }
                    }
                    else if (userAnswer.equalsIgnoreCase("F"))
                    {
                        System.out.println("Enter future sale amount: ");
                        double futureSale = in.nextDouble();
                        System.out.println("Enter a brief description for future sale: ");
                        String futureDesc = in.nextLine();

                        /*
                            Updates accounts for future sale
                         */
                        Accounts thisFuture = new Accounts(futureDesc, futureSale);
                        thisFuture.creditUnearnedRevenue(futureSale);
                        thisFuture.debitCash(futureSale);
                    }
                }
                else if(answer.equalsIgnoreCase("P"))
                {
                    System.out.println("Enter amount paid out: ");
                    double amountPaid = in.nextDouble();
                    System.out.println("Enter if purchase of S) Supplies R) Rent A) A/P payment N) Note payable payment (Any other button to exit): ");
                    String paidOutThis = in.nextLine();
                    if (paidOutThis.equalsIgnoreCase("S"))
                    {
                        System.out.println("Enter a brief description for purchase of supplies: ");
                        String suppliesDesc = in.nextLine();

                        Accounts thisSupplies = new Accounts(suppliesDesc ,amountPaid);
                        thisSupplies.debitSupplies(amountPaid);
                        thisSupplies.creditCash(amountPaid);
                    }
                    else if (paidOutThis.equalsIgnoreCase("(R"))
                    {
                        System.out.println("Enter a brief description for rent payment: ");
                        String rentDesc = in.nextLine();

                        Accounts thisRent = new Accounts(rentDesc, amountPaid);
                        thisRent.creditCash(amountPaid);
                        thisRent.debitRentExpense(amountPaid);
                    }
                    else if (paidOutThis.equalsIgnoreCase("A"))
                    {
                        /*
                            Ask for more options to determine what accounts user wishes to update
                            to do add creation of objects and method calls.
                         */
                    }
                    else if (paidOutThis.equalsIgnoreCase("N"))
                    {
                        System.out.println("Enter brief description for Notes Payable payment: ");
                        String noteDesc = in.nextLine();

                        Accounts thisNote = new Accounts(noteDesc, amountPaid);
                        thisNote.debitNotePayable(amountPaid);
                        thisNote.creditCash(amountPaid);
                    }
                }
                else if(answer.equalsIgnoreCase("I"))
                {
                    System.out.println("Enter if O) Ordering or U) Used Accounts (Any other button to exit):");
                    String inputAnswer = in.nextLine();
                    if (inputAnswer.equalsIgnoreCase("O"))
                    {
                        System.out.println("Enter if ordering for E) Equipment or I) Inventory: ");
                        String userAnswer = in.nextLine();
                        if (userAnswer.equalsIgnoreCase("E")) {
                            System.out.println("Enter if paid with C) Cash or A) A/P or M) Mixture (Any other button to exit): ");
                            String userInputAnswer = in.nextLine();
                            if (userInputAnswer.equalsIgnoreCase("C"))
                            {
                                System.out.println("Enter amount of Cash paid: ");
                                double thisCashPaid = in.nextDouble();
                                System.out.println("Enter a brief description for Equipment purchase: ");
                                String equipDesc = in.nextLine();

                                Accounts thisEquip = new Accounts(equipDesc,thisCashPaid);
                                thisEquip.debitEquipment(thisCashPaid);
                                thisEquip.creditCash(thisCashPaid);
                            }
                            else if (userInputAnswer.equalsIgnoreCase("A"))
                            {
                                System.out.println("Enter amount to be paid: ");
                                double thisPayable = in.nextDouble();
                                System.out.println("Enter a brief description for purchase of equipment: ");
                                String equipDesc = in.nextLine();

                                Accounts thisEquip = new Accounts(equipDesc, thisPayable);
                                thisEquip.creditAccountsPayable(thisPayable);
                                thisEquip.debitEquipment(thisPayable);
                            }
                            else if (userInputAnswer.equalsIgnoreCase("M"))
                            {
                                System.out.println("Enter amount to be paid with cash: ");
                                double thisCash = in.nextDouble();
                                System.out.println("Enter amount to be paid in future: ");
                                double thisPayable = in.nextDouble();

                                System.out.println("Enter description for this equipment purchase: ");
                                String equipDesc = in.nextLine();

                                Accounts thisEquipCash = new Accounts(equipDesc, thisCash);
                                Accounts thisEquipPayable = new Accounts(equipDesc, thisPayable);
                                thisEquipCash.creditCash(thisCash);
                                thisEquipPayable.creditAccountsPayable(thisPayable);
                                thisEquipCash.debitEquipment(thisCash+thisPayable);
                            }
                        }
                        else if (userAnswer.equalsIgnoreCase("I"))
                        {
                            System.out.println("Enter if paid with C) Cash or A) A/P or M) Mixture (Any other button to exit): ");
                            String paidOutAnswer = in.nextLine();
                            if (paidOutAnswer.equalsIgnoreCase("C"))
                            {
                                System.out.println("Enter amount of Cash paid: ");
                                double thisCashPaid = in.nextDouble();
                                System.out.println("Enter a brief description for Inventory purchase: ");
                                String inventoryDesc = in.nextLine();

                                Accounts thisInventory = new Accounts(inventoryDesc,thisCashPaid);
                                thisInventory.debitInventory(thisCashPaid);
                                thisInventory.creditCash(thisCashPaid);
                            }
                            else if (paidOutAnswer.equalsIgnoreCase("A"))
                            {
                                System.out.println("Enter amount to be paid: ");
                                double thisPayable = in.nextDouble();
                                System.out.println("Enter a brief description for purchase of inventory: ");
                                String inventoryDesc = in.nextLine();

                                Accounts thisInventory = new Accounts(inventoryDesc, thisPayable);
                                thisInventory.creditAccountsPayable(thisPayable);
                                thisInventory.debitEquipment(thisPayable);
                            }
                            else if (paidOutAnswer.equalsIgnoreCase("M"))
                            {
                                System.out.println("Enter amount to be paid with cash: ");
                                double thisCash = in.nextDouble();
                                System.out.println("Enter amount to be paid in future: ");
                                double thisPayable = in.nextDouble();

                                System.out.println("Enter description for this inventory purchase: ");
                                String inventoryDesc = in.nextLine();

                                Accounts thisInventoryCash = new Accounts(inventoryDesc, thisCash);
                                Accounts thisInventoryPayable = new Accounts(inventoryDesc, thisPayable);
                                thisInventoryCash.creditCash(thisCash);
                                thisInventoryPayable.creditAccountsPayable(thisPayable);
                                thisInventoryCash.debitInventory(thisCash+thisPayable);
                            }
                        }
                    }
                    else if(inputAnswer.equalsIgnoreCase("U"))
                    {
                        System.out.print("Enter whether use of E) Equipment or I) Inventory: ");
                        String userAnswer = in.nextLine();
                        if (userAnswer.equalsIgnoreCase("E"))
                        {
                            System.out.println("Enter amount to adjust Equipment: ");
                            double adjustAmount = in.nextDouble();
                            System.out.println("Enter a description for adjustment amount: ");
                            String adjustDesc = in.nextLine();

                            Accounts adjustEntry = new Accounts(adjustDesc, adjustAmount);
                            adjustEntry.creditEquipment(adjustAmount);
                            adjustEntry.debitRevenue(adjustAmount);
                        }
                        else if(userAnswer.equalsIgnoreCase("I"))
                        {
                            System.out.println("Enter amount to adjust Inventory: ");
                            double invAdjust = in.nextDouble();
                            System.out.println("Enter a description for adjustment amount: ");
                            String invDesc = in.nextLine();

                            Accounts adjustInv = new Accounts(invDesc, invAdjust);
                            adjustInv.creditInventory(invAdjust);
                            adjustInv.debitRevenue(invAdjust);

                        }

                    }
                }
                else if(answer.equalsIgnoreCase("S"))
                {
                    System.out.println("Enter if Stock S) Sold or B) Bought (Any other button to exit: ");
                    String userAnswer = in.nextLine();
                    if (userAnswer.equalsIgnoreCase("S"))
                    {
                        System.out.println("Enter dollar amount of stock sold: ");
                        double soldStock = in.nextDouble();
                        System.out.println("Enter a brief description of stock sold: ");
                        String stockDesc = in.nextLine();

                        Accounts thisStock = new Accounts(stockDesc,soldStock);
                        thisStock.creditStock(soldStock);
                        thisStock.debitCash(soldStock);
                    }
                    else if(userAnswer.equalsIgnoreCase("B"))
                    {
                        System.out.println("Enter dollar amount of stock purchased: ");
                        double stockBought = in.nextDouble();
                        System.out.println("Enter a brief description of stock purchased: ");
                        String stockDesc = in.nextLine();

                        Accounts thisStock = new Accounts(stockDesc, stockBought);
                        thisStock.debitStock(stockBought);
                        thisStock.creditCash(stockBought);
                    }
                }
                else if(answer.equalsIgnoreCase("E"))
                {
                    System.out.println("Enter total Expenses: ");
                    double totalExpenses = in.nextDouble();
                    System.out.println("Enter if O) Operating W) Wages");
                    String userAnswer = in.nextLine();
                    if (userAnswer.equalsIgnoreCase("O"))
                    {
                        System.out.println("Enter a brief description for operating expense: ");
                        String operatingDesc = in.nextLine();

                        Accounts thisOperatingExpense = new Accounts(operatingDesc, totalExpenses);
                        thisOperatingExpense.debitOperatingExpense(totalExpenses);
                        thisOperatingExpense.creditCash(totalExpenses);
                    }
                    else if (userAnswer.equalsIgnoreCase("W"))
                    {
                        System.out.println("Enter a brief description for Wages expense: ");
                        String wagesDesc = in.nextLine();

                        Accounts thisWages = new Accounts(wagesDesc, totalExpenses);
                        thisWages.debitWagesExpense(totalExpenses);
                        thisWages.creditCash(totalExpenses);
                    }
                }
            }
            else if (userInput.equals("P"))
            {
                //To do call arrayList class Account Entries and call print method.
                //Empty account object
                String emptyDesc = null;
                double noAmount = 0.00;
                Accounts emptyAccounts = new Accounts(emptyDesc, noAmount);
                emptyAccounts.updateBalanceSheet();

                System.out.println("Assets " + Accounts.totalAssets);
                System.out.println("Liab " + Accounts.totalLiabilities);
                System.out.println("stockHolders" + Accounts.stockholdersEquity);
                System.out.println("estimateSE" + Accounts.estimateSE);

                emptyAccounts.updateIncomeStatement();

                System.out.println("Revenues " + Accounts.totalRevenue);
                System.out.println("Expenses " + Accounts.totalExpenses);
                System.out.println("Income " + Accounts.totalIncome);
            }
            else if (userInput.equals("Q"))
            {
                done = true;
            }
        }

    }
}
