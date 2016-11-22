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

        AccountEntries allEntries = new AccountEntries();

        boolean done = false;
        while(!done)
        {
            System.out.print("I) Initialize database A) Add Entry P) Print Q) Quit: ");
            String userInput = in.next().toUpperCase();
            if (userInput.equals("I"))
            {
               System.out.print("Enter Y) Yes to confirm Initialization Q) Quit (Any other button to return to exit): ");
               String answer = in.next();
                if (answer.equalsIgnoreCase("Y"))
                {
                    System.out.print("Enter assets: ");
                    double assets = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter liabilities: ");
                    double liabilities = in.nextDouble();
                    in.nextLine();
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
                System.out.print("R) Record sale P) Pay out I) Inventory and equipment S) Stock B) Borrow money E) Expenses Q) Quit (Any other button to exit): ");
                String answer = in.next();
                if (answer.equalsIgnoreCase("R"))
                {
                    System.out.print("Enter if sold T) Today or F) Future? Q) Quit (Any other button to exit): ");
                    String userAnswer = in.next();
                    if (userAnswer.equalsIgnoreCase("T")) {
                        System.out.print("Enter total sale amount: ");
                        double totalSale = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter cash collected: ");
                        double cashCollect = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter A/R: ");
                        double accountsReceivable = in.nextDouble();

                        /*
                        Create account object for total sale, portion paid with cash, and A/R
                        */
                        if (totalSale == cashCollect) {
                            System.out.print("Enter a brief description for the total sale: ");
                            String accountDesc = in.next();
                            in.nextLine();
                            Accounts thisSale = new Accounts(accountDesc, totalSale);
                            thisSale.creditRevenue(totalSale);
                            thisSale.debitCash(totalSale);

                            allEntries.addAccountEntry(thisSale);

                        } else if (totalSale != cashCollect || cashCollect > 0) {

                            System.out.print("Enter a brief description for the portion paid with cash: ");
                            String cashDesc = in.next();
                            in.nextLine();
                            Accounts thisCash = new Accounts(cashDesc, cashCollect);
                            thisCash.debitCash(cashCollect);
                            thisCash.creditRevenue(cashCollect);
                            System.out.print("Enter a brief description for the portion paid with A/R: ");
                            String receivablesDesc = in.next();

                            in.nextLine();

                            double receivables = totalSale - cashCollect;
                            Accounts thisReceive = new Accounts(receivablesDesc, receivables);
                            thisReceive.debitAccountsReceivable(receivables);
                            thisReceive.creditRevenue(receivables);

                            allEntries.addAccountEntry(thisCash);
                            allEntries.addAccountEntry(thisReceive);

                        } else {

                            System.out.print("Enter a brief description for the sale paid with A/R: ");
                            String receivablesDesc = in.next();
                            in.nextLine();
                            Accounts thisAccountsReceivable = new Accounts(receivablesDesc, accountsReceivable);
                            thisAccountsReceivable.debitAccountsReceivable(accountsReceivable);
                            thisAccountsReceivable.creditRevenue(accountsReceivable);

                            allEntries.addAccountEntry(thisAccountsReceivable);
                        }
                    }
                    else if (userAnswer.equalsIgnoreCase("F"))
                    {
                        System.out.print("Enter if E) Entering future sale or R) Reconciling previous: ");
                        String futureAnswer = in.next();
                        if(futureAnswer.equalsIgnoreCase("E"))
                        {
                            System.out.print("Enter future sale amount: ");
                            double futureSale = in.nextDouble();
                            in.nextLine();
                            System.out.print("Enter a brief description for future sale: ");
                            String futureDesc = in.next();
                            in.nextLine();

                            Accounts thisFuture = new Accounts (futureDesc, futureSale);
                            thisFuture.creditUnearnedRevenue(futureSale);
                            thisFuture.debitCash(futureSale);

                            allEntries.addAccountEntry(thisFuture);
                        }
                        else if (futureAnswer.equalsIgnoreCase("R"))
                        {
                            System.out.print("Enter amount of earned revenue: ");
                            double futureSale = in.nextDouble();
                            in.nextLine();
                            System.out.print("Enter a brief description for sale: ");
                            String futureDesc = in.next();
                            in.nextLine();

                            Accounts thisFuture = new Accounts(futureDesc, futureSale);
                            thisFuture.debitUnearnedRevenue(futureSale);
                            thisFuture.creditRevenue(futureSale);
                        }
                    }
                    else if(userAnswer.equalsIgnoreCase("Q"))
                    {
                        done = true;
                    }
                }
                else if(answer.equalsIgnoreCase("P"))
                {
                    System.out.print("Enter amount paid out: ");
                    double amountPaid = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter if purchase of S) Supplies R) Rent A) A/P payment N) Note payable payment Q) Quit (Any other button to exit): ");
                    String paidOutThis = in.next();
                    if (paidOutThis.equalsIgnoreCase("S"))
                    {
                        System.out.print("Enter a brief description for purchase of supplies: ");
                        String suppliesDesc = in.next();
                        in.nextLine();

                        Accounts thisSupplies = new Accounts(suppliesDesc ,amountPaid);
                        thisSupplies.debitSupplies(amountPaid);
                        thisSupplies.creditCash(amountPaid);

                        allEntries.addAccountEntry(thisSupplies);
                    }
                    else if (paidOutThis.equalsIgnoreCase("(R"))
                    {
                        System.out.print("Enter a brief description for rent payment: ");
                        String rentDesc = in.next();
                        in.nextLine();

                        Accounts thisRent = new Accounts(rentDesc, amountPaid);
                        thisRent.creditCash(amountPaid);
                        thisRent.debitRentExpense(amountPaid);

                        allEntries.addAccountEntry(thisRent);
                    }
                    else if (paidOutThis.equalsIgnoreCase("A"))
                    {
                        System.out.print("Enter a brief description for Accounts Payable payment: ");
                        String payDesc = in.next();
                        in.nextLine();

                        Accounts thisPayable = new Accounts(payDesc, amountPaid);
                        thisPayable.debitAccountsPayable(amountPaid);
                        thisPayable.creditCash(amountPaid);

                        allEntries.addAccountEntry(thisPayable);
                    }
                    else if (paidOutThis.equalsIgnoreCase("N"))
                    {
                        System.out.print("Enter brief description for Notes Payable payment: ");
                        String noteDesc = in.next();
                        in.nextLine();

                        Accounts thisNote = new Accounts(noteDesc, amountPaid);
                        thisNote.debitNotePayable(amountPaid);
                        thisNote.creditCash(amountPaid);

                        allEntries.addAccountEntry(thisNote);
                    }
                    else if (paidOutThis.equalsIgnoreCase("Q"))
                    {
                        done = true;
                    }
                }
                else if(answer.equalsIgnoreCase("I"))
                {
                    System.out.print("Enter if O) Ordering or U) Used Accounts Q) Quit (Any other button to exit): ");
                    String inputAnswer = in.next();
                    if (inputAnswer.equalsIgnoreCase("O"))
                    {
                        System.out.print("Enter if ordering for E) Equipment or I) Inventory: ");
                        String userAnswer = in.next();
                        if (userAnswer.equalsIgnoreCase("E")) {
                            System.out.print("Enter if paid with C) Cash or A) A/P or M) Mixture (Any other button to exit): ");
                            String userInputAnswer = in.next();
                            if (userInputAnswer.equalsIgnoreCase("C"))
                            {
                                System.out.print("Enter amount of Cash paid: ");
                                double thisCashPaid = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter a brief description for Equipment purchase: ");
                                String equipDesc = in.next();
                                in.nextLine();

                                Accounts thisEquip = new Accounts(equipDesc,thisCashPaid);
                                thisEquip.debitEquipment(thisCashPaid);
                                thisEquip.creditCash(thisCashPaid);

                                allEntries.addAccountEntry(thisEquip);
                            }
                            else if (userInputAnswer.equalsIgnoreCase("A"))
                            {
                                System.out.print("Enter amount to be paid: ");
                                double thisPayable = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter a brief description for purchase of equipment: ");
                                String equipDesc = in.next();
                                in.nextLine();

                                Accounts thisEquip = new Accounts(equipDesc, thisPayable);
                                thisEquip.creditAccountsPayable(thisPayable);
                                thisEquip.debitEquipment(thisPayable);

                                allEntries.addAccountEntry(thisEquip);
                            }
                            else if (userInputAnswer.equalsIgnoreCase("M"))
                            {
                                System.out.print("Enter amount to be paid with cash: ");
                                double thisCash = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter amount to be paid in future: ");
                                double thisPayable = in.nextDouble();
                                in.nextLine();

                                System.out.print("Enter description for this equipment purchase: ");
                                String equipDesc = in.next();
                                in.nextLine();

                                Accounts thisEquipCash = new Accounts(equipDesc, thisCash);
                                Accounts thisEquipPayable = new Accounts(equipDesc, thisPayable);
                                thisEquipCash.creditCash(thisCash);
                                thisEquipPayable.creditAccountsPayable(thisPayable);
                                thisEquipCash.debitEquipment(thisCash+thisPayable);

                                allEntries.addAccountEntry(thisEquipCash);
                                allEntries.addAccountEntry(thisEquipPayable);
                            }
                        }
                        else if (userAnswer.equalsIgnoreCase("I"))
                        {
                            System.out.print("Enter if paid with C) Cash or A) A/P or M) Mixture (Any other button to exit): ");
                            String paidOutAnswer = in.next();
                            if (paidOutAnswer.equalsIgnoreCase("C"))
                            {
                                System.out.print("Enter amount of Cash paid: ");
                                double thisCashPaid = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter a brief description for Inventory purchase: ");
                                String inventoryDesc = in.next();
                                in.nextLine();

                                Accounts thisInventory = new Accounts(inventoryDesc,thisCashPaid);
                                thisInventory.debitInventory(thisCashPaid);
                                thisInventory.creditCash(thisCashPaid);

                                allEntries.addAccountEntry(thisInventory);
                            }
                            else if (paidOutAnswer.equalsIgnoreCase("A"))
                            {
                                System.out.print("Enter amount to be paid: ");
                                double thisPayable = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter a brief description for purchase of inventory: ");
                                String inventoryDesc = in.next();
                                in.nextLine();

                                Accounts thisInventory = new Accounts(inventoryDesc, thisPayable);
                                thisInventory.creditAccountsPayable(thisPayable);
                                thisInventory.debitEquipment(thisPayable);

                                allEntries.addAccountEntry(thisInventory);
                            }
                            else if (paidOutAnswer.equalsIgnoreCase("M"))
                            {
                                System.out.print("Enter amount to be paid with cash: ");
                                double thisCash = in.nextDouble();
                                in.nextLine();
                                System.out.print("Enter amount to be paid in future: ");
                                double thisPayable = in.nextDouble();
                                in.nextLine();

                                System.out.print("Enter description for this inventory purchase: ");
                                String inventoryDesc = in.next();
                                in.nextLine();

                                Accounts thisInventoryCash = new Accounts(inventoryDesc, thisCash);
                                Accounts thisInventoryPayable = new Accounts(inventoryDesc, thisPayable);
                                thisInventoryCash.creditCash(thisCash);
                                thisInventoryPayable.creditAccountsPayable(thisPayable);
                                thisInventoryCash.debitInventory(thisCash+thisPayable);

                                allEntries.addAccountEntry(thisInventoryCash);
                                allEntries.addAccountEntry(thisInventoryPayable);
                            }
                        }
                        else if (userAnswer.equalsIgnoreCase("Q"))
                        {
                            done = true;
                        }
                    }
                    else if(inputAnswer.equalsIgnoreCase("U"))
                    {
                        System.out.print("Enter whether use of E) Equipment or I) Inventory: ");
                        String userAnswer = in.next();
                        if (userAnswer.equalsIgnoreCase("E"))
                        {
                            System.out.print("Enter amount to adjust Equipment: ");
                            double adjustAmount = in.nextDouble();
                            in.nextLine();
                            System.out.print("Enter a description for adjustment amount: ");
                            String adjustDesc = in.next();
                            in.nextLine();

                            Accounts adjustEntry = new Accounts(adjustDesc, adjustAmount);
                            adjustEntry.creditEquipment(adjustAmount);
                            adjustEntry.debitRevenue(adjustAmount);

                            allEntries.addAccountEntry(adjustEntry);
                        }
                        else if(userAnswer.equalsIgnoreCase("I"))
                        {
                            System.out.print("Enter amount to adjust Inventory: ");
                            double invAdjust = in.nextDouble();
                            in.nextLine();
                            System.out.print("Enter a description for adjustment amount: ");
                            String invDesc = in.next();
                            in.nextLine();

                            Accounts adjustInv = new Accounts(invDesc, invAdjust);
                            adjustInv.creditInventory(invAdjust);
                            adjustInv.debitRevenue(invAdjust);

                            allEntries.addAccountEntry(adjustInv);

                        }

                    }
                }
                else if (answer.equalsIgnoreCase("B"))
                {
                    System.out.print("Enter amount of money borrowed: ");
                    double cashBorrow = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter a brief description for this loan: ");
                    String loanDesc = in.next();

                    Accounts thisLoan = new Accounts(loanDesc, cashBorrow);
                    thisLoan.debitCash(cashBorrow);
                    thisLoan.creditNotesPayable(cashBorrow);

                    allEntries.addAccountEntry(thisLoan);
                }
                else if(answer.equalsIgnoreCase("S"))
                {
                    System.out.print("Enter if Stock S) Sold or B) Bought (Any other button to exit: ");
                    String userAnswer = in.next();
                    if (userAnswer.equalsIgnoreCase("S"))
                    {
                        System.out.print("Enter dollar amount of stock sold: ");
                        double soldStock = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter a brief description of stock sold: ");
                        String stockDesc = in.next();
                        in.nextLine();

                        Accounts thisStock = new Accounts(stockDesc,soldStock);
                        thisStock.creditStock(soldStock);
                        thisStock.debitCash(soldStock);

                        allEntries.addAccountEntry(thisStock);
                    }
                    else if(userAnswer.equalsIgnoreCase("B"))
                    {
                        System.out.print("Enter dollar amount of stock purchased: ");
                        double stockBought = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter a brief description of stock purchased: ");
                        String stockDesc = in.next();
                        in.nextLine();

                        Accounts thisStock = new Accounts(stockDesc, stockBought);
                        thisStock.debitStock(stockBought);
                        thisStock.creditCash(stockBought);

                        allEntries.addAccountEntry(thisStock);
                    }
                }
                else if(answer.equalsIgnoreCase("E"))
                {
                    System.out.print("Enter total Expenses: ");
                    double totalExpenses = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter if O) Operating W) Wages");
                    String userAnswer = in.next();
                    if (userAnswer.equalsIgnoreCase("O"))
                    {
                        System.out.print("Enter a brief description for operating expense: ");
                        String operatingDesc = in.next();
                        in.nextLine();

                        Accounts thisOperatingExpense = new Accounts(operatingDesc, totalExpenses);
                        thisOperatingExpense.debitOperatingExpense(totalExpenses);
                        thisOperatingExpense.creditCash(totalExpenses);

                        allEntries.addAccountEntry(thisOperatingExpense);
                    }
                    else if (userAnswer.equalsIgnoreCase("W"))
                    {
                        System.out.print("Enter a brief description for Wages expense: ");
                        String wagesDesc = in.next();
                        in.nextLine();

                        Accounts thisWages = new Accounts(wagesDesc, totalExpenses);
                        thisWages.debitWagesExpense(totalExpenses);
                        thisWages.creditCash(totalExpenses);

                        allEntries.addAccountEntry(thisWages);
                    }
                }
                else if (answer.equalsIgnoreCase("Q"))
                {
                    done = true;
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

                String listOfAccounts = allEntries.entriesToString();

                System.out.println(listOfAccounts);
            }
            else if (userInput.equals("Q"))
            {
                done = true;
            }
        }

    }
}
